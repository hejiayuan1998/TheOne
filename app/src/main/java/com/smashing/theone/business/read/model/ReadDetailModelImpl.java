package com.smashing.theone.business.read.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;
import com.smashing.theone.api.Api;
import com.smashing.theone.business.read.contract.ReadDetailContract;

import rx.Observable;

/**
 * Created by chensen on 2017/03/30
 */

public class ReadDetailModelImpl implements ReadDetailContract.Model {

    @Override
    public Observable<String> getDetail(String itemId) {
        return OkGo.get(Api.READ_DETAIL  + itemId)
                .getCall(StringConvert.create(), RxAdapter.<String>create());

    }
    @Override
    public Observable<String> getComment(String itemId) {
        return OkGo.get(Api.READ_COMMENT + itemId + "/0").getCall(StringConvert.create(), RxAdapter.<String>create());
    }
}