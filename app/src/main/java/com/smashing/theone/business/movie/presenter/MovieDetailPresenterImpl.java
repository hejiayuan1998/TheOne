package com.smashing.theone.business.movie.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.smashing.theone.bean.CommentBean;
import com.smashing.theone.business.movie.contract.MovieDetailContract;
import com.smashing.theone.business.movie.model.MovieDetailBean;
import com.smashing.theone.business.movie.model.MovieDetailModelImpl;
import com.smashing.theone.business.movie.model.MoviePicBean;
import com.smashing.theone.business.movie.view.MovieDetailActivity;
import com.smashing.theone.common.base.BasePresenter;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by chensen on 2017/03/31
 */

public class MovieDetailPresenterImpl extends BasePresenter<MovieDetailActivity, MovieDetailModelImpl> implements MovieDetailContract.Presenter {

    public MovieDetailPresenterImpl(MovieDetailActivity mView, MovieDetailModelImpl mModel) {
        super(mView, mModel);
    }

    @Override
    public void getPic(String itemId) {
        Subscription subscribe = mModel.getPic(itemId)
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
                        Log.d("tag", "ee-->" + e.toString());
                    }

                    @Override
                    public void onNext(String s) {
                        MoviePicBean moviePicBean = new Gson().fromJson(s, MoviePicBean.class);
                        mView.showPic(moviePicBean.getData());
                    }
                });
        addSubscribe(subscribe);
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
                        mView.showError();
                        Log.d("tag", "ee-->" + e.toString());
                    }

                    @Override
                    public void onNext(String s) {
                        MovieDetailBean movieDetailBean = new Gson().fromJson(s, MovieDetailBean.class);
                        mView.showContent(movieDetailBean.getData().getData().get(0));
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
                        Log.d("tag", "ee-->" + e.toString());
                    }

                    @Override
                    public void onNext(String s) {
                        CommentBean commentBean = new Gson().fromJson(s, CommentBean.class);
                        mView.showComment(commentBean.getData().getData());

                    }
                });
        addSubscribe(subscribe);
    }
}