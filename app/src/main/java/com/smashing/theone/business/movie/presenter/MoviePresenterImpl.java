package com.smashing.theone.business.movie.presenter;

import com.google.gson.Gson;
import com.smashing.theone.bean.Content;
import com.smashing.theone.business.movie.contract.MovieContract;
import com.smashing.theone.business.movie.model.MovieModelImpl;
import com.smashing.theone.business.movie.view.MovieFragment;
import com.smashing.theone.business.read.model.ReadBean;
import com.smashing.theone.common.base.BasePresenter;

import java.util.ArrayList;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by chensen on 2017/03/25
 */

public class MoviePresenterImpl extends BasePresenter<MovieFragment, MovieModelImpl> implements MovieContract.Presenter {
    ArrayList<Content> data;

    public MoviePresenterImpl(MovieFragment mView, MovieModelImpl mModel) {
        super(mView, mModel);
    }

    @Override
    public void getList() {
        Subscription subscribe = mModel.getList()
                .subscribeOn(Schedulers.io())
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
                        ReadBean movieBean = new Gson().fromJson(s, ReadBean.class);
                        data = movieBean.getData();
                        mView.showList(data);
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public String getItemId(int position) {
        return data.get(position).getItem_id();
    }
}