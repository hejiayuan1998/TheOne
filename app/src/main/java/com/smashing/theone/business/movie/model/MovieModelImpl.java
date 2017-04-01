package com.smashing.theone.business.movie.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;
import com.smashing.theone.api.Api;
import com.smashing.theone.business.movie.contract.MovieContract;

import rx.Observable;

/**
 * Created by chensen on 2017/03/25
 */

public class MovieModelImpl implements MovieContract.Model {

    @Override
    public Observable<String> getList() {

        return OkGo.get(Api.MOVIE_LIST)
                .getCall(StringConvert.create(), RxAdapter.<String>create());
    }
}