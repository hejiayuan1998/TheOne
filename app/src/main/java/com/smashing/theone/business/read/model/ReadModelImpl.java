package com.smashing.theone.business.read.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;
import com.smashing.theone.api.Api;
import com.smashing.theone.business.read.contract.ReadContract;

import rx.Observable;

/**
 * Created by chensen on 2017/03/28
 */

public class ReadModelImpl implements ReadContract.Model {

    @Override
    public Observable<String> getList() {
        return OkGo.get(Api.READ_LIST)
                .getCall(StringConvert.create(),RxAdapter.<String>create());
    }
}