package com.smashing.theone.business.read.presenter;

import com.google.gson.Gson;
import com.smashing.theone.business.read.contract.QuestionContract;
import com.smashing.theone.business.read.model.QuestionBean;
import com.smashing.theone.business.read.model.QuestionModelImpl;
import com.smashing.theone.business.read.view.QuestionDetilActivity;
import com.smashing.theone.common.base.BasePresenter;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by chensen on 2017/04/01
 */

public class QuestionPresenterImpl extends BasePresenter<QuestionDetilActivity, QuestionModelImpl> implements QuestionContract.Presenter {

    public QuestionPresenterImpl(QuestionDetilActivity mView, QuestionModelImpl mModel) {
        super(mView, mModel);
    }

    @Override
    public void getContent(String itemId) {
        Subscription subscribe = mModel.getContent(itemId)
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

                    }

                    @Override
                    public void onNext(String s) {
                        QuestionBean questionBean = new Gson().fromJson(s, QuestionBean.class);
                        mView.showContent(questionBean.getData());

                    }
                });
        addSubscribe(subscribe);
    }
}