package com.smashing.theone.business.home.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;
import com.smashing.theone.api.Api;
import com.smashing.theone.business.home.contract.OneListContract;

import rx.Observable;

/**
 * Created by chensen on 2017/03/24
 */

public class OneListModelImpl implements OneListContract.Model {


    @Override
    public Observable<String> getIdList() {
        return   OkGo.get(Api.ID_LIST)
                .getCall(StringConvert.create(), RxAdapter.<String>create());

    }

    @Override
    public Observable<String>  getOneList(String id) {
        return OkGo.get(Api.ONE_LIST +id+"/0")
                .getCall(StringConvert.create(), RxAdapter.<String>create());
    }
}