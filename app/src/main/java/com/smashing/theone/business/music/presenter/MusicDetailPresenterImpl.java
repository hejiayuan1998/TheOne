package com.smashing.theone.business.music.presenter;

import com.google.gson.Gson;
import com.smashing.theone.bean.CommentBean;
import com.smashing.theone.business.music.contract.MusicDetailContract;
import com.smashing.theone.business.music.model.MusicDetailBean;
import com.smashing.theone.business.music.model.MusicDetailModelImpl;
import com.smashing.theone.business.music.view.MusicDetailActivity;
import com.smashing.theone.common.base.BasePresenter;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by chensen on 2017/03/30
 */

public class MusicDetailPresenterImpl extends BasePresenter<MusicDetailActivity, MusicDetailModelImpl> implements MusicDetailContract.Presenter {

    public MusicDetailPresenterImpl(MusicDetailActivity mView, MusicDetailModelImpl mModel) {
        super(mView, mModel);
    }

    @Override
    public void getContent(String itemId) {
        Subscription subscribe = mModel.getContent(itemId)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mView.showLoading();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();

                    }

                    @Override
                    public void onNext(String s) {
                        MusicDetailBean musicDetailBean = new Gson().fromJson(s, MusicDetailBean.class);
                        mView.showContent(musicDetailBean.getData());
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getComment(String itemId) {
        Subscription subscribe = mModel.getComment(itemId)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();

                    }

                    @Override
                    public void onNext(String s) {
                        CommentBean commentBean = new Gson().fromJson(s, CommentBean.class);
                        if (commentBean.getData().getData() != null && commentBean.getData().getData().size() > 0) {
                            mView.showComment(commentBean.getData().getData());
                        }
                    }
                });
        addSubscribe(subscribe);
    }


    @Override
    public void getMusic() {

    }
}