package com.smashing.theone.business.home.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.smashing.theone.business.home.contract.OneListContract;
import com.smashing.theone.business.home.model.OneListBean;
import com.smashing.theone.business.home.model.OneListModelImpl;
import com.smashing.theone.business.home.view.OneListFragment;
import com.smashing.theone.common.base.BasePresenter;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;


/**
 * Created by chensen on 2017/03/24
 */

public class OneListPresenterImpl extends BasePresenter<OneListFragment, OneListModelImpl> implements OneListContract.Presenter {


    public OneListPresenterImpl(OneListFragment mView, OneListModelImpl mModel) {
        super(mView, mModel);
    }

    @Override
    public void getOneList(String id) {
        Subscription subscribe = mModel.getOneList(id)
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
                        Log.d("getOneList", "Throwable--" + e);
                        mView.showError();
                    }

                    @Override
                    public void onNext(String s) {
                        OneListBean oneListBean = new Gson().fromJson(s, OneListBean.class);
                        mView.showSuccess();
                        mView.showWeather(oneListBean.getData().getWeather(), oneListBean.getData().getDate());
                        mView.showOneList(oneListBean.getData().getContent_list());
                    }
                });
        addSubscribe(subscribe);
    }


}