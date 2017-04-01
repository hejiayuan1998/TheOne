package com.smashing.theone.business.read.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.smashing.theone.bean.CommentBean;
import com.smashing.theone.business.read.contract.ReadDetailContract;
import com.smashing.theone.business.read.model.ReadDetailBean;
import com.smashing.theone.business.read.model.ReadDetailModelImpl;
import com.smashing.theone.business.read.view.ReadDetailActivity;
import com.smashing.theone.common.base.BasePresenter;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by chensen on 2017/03/30
 */

public class ReadDetailPresenterImpl extends BasePresenter<ReadDetailActivity, ReadDetailModelImpl> implements ReadDetailContract.Presenter {


    public ReadDetailPresenterImpl(ReadDetailActivity mView, ReadDetailModelImpl mModel) {
        super(mView, mModel);
    }

    @Override
    public void getDetail(String itemId) {

        Subscription subscribe = mModel.getDetail(itemId)
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
                        Log.d("tag","e-"+e.toString());
                    }

                    @Override
                    public void onNext(String s) {
                        ReadDetailBean readDetailBean = new Gson().fromJson(s, ReadDetailBean.class);
                        mView.showContent(readDetailBean);


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
}