package com.smashing.theone.business.movie.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;
import com.smashing.theone.api.Api;
import com.smashing.theone.business.movie.contract.MovieDetailContract;

import rx.Observable;

/**
 * Created by chensen on 2017/03/31
 */

public class MovieDetailModelImpl implements MovieDetailContract.Model {

    @Override
    public Observable<String> getPic(String itemId) {
        return OkGo.get(Api.MOVIE_DETAIL_PIC.replace("itemId", itemId)).getCall(StringConvert.create(), RxAdapter.<String>create());
    }

    @Override
    public Observable<String> getContent(String itemId) {
        return OkGo.get(Api.MOVIE_DETAIL.replace("itemId", itemId)).getCall(StringConvert.create(), RxAdapter.<String>create());
    }

    @Override
    public Observable<String> getComment(String itemId) {
        return OkGo.get(Api.MOVIE_COMMENT.replace("itemId", itemId)).getCall(StringConvert.create(), RxAdapter.<String>create());
    }
}