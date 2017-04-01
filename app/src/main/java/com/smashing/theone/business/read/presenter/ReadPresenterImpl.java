package com.smashing.theone.business.read.presenter;

import com.google.gson.Gson;
import com.smashing.theone.bean.Content;
import com.smashing.theone.business.read.contract.ReadContract;
import com.smashing.theone.business.read.model.ReadBean;
import com.smashing.theone.business.read.model.ReadModelImpl;
import com.smashing.theone.business.read.view.ReadFragment;
import com.smashing.theone.common.base.BasePresenter;

import java.util.ArrayList;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by chensen on 2017/03/28
 */

public class ReadPresenterImpl extends BasePresenter<ReadFragment, ReadModelImpl> implements ReadContract.Presenter {
    ArrayList<Content> listData;

    public ReadPresenterImpl(ReadFragment mView, ReadModelImpl mModel) {
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
                        ReadBean readBean = new Gson().fromJson(s, ReadBean.class);
                        listData = readBean.getData();
                        mView.showList(listData);
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public String getItemId(int position) {
        return listData.get(position).getItem_id();
    }


}