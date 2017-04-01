package com.smashing.theone.business.read.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;
import com.smashing.theone.api.Api;
import com.smashing.theone.business.read.contract.QuestionContract;

import rx.Observable;

/**
 * Created by chensen on 2017/04/01
 */

public class QuestionModelImpl implements QuestionContract.Model {

    @Override
    public Observable<String> getContent(String itemId) {
        return OkGo.get(Api.READ_QUESTION).getCall(StringConvert.create(), RxAdapter.<String>create());
    }
}