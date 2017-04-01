package com.smashing.theone.business.music.model;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;
import com.smashing.theone.api.Api;
import com.smashing.theone.business.music.contract.MusicDetailContract;

import rx.Observable;

/**
 * Created by chensen on 2017/03/30
 */

public class MusicDetailModelImpl implements MusicDetailContract.Model {

    @Override
    public Observable<String> getContent(String itemId) {

        return OkGo.get(Api.MUSIC_DETAIL + itemId).getCall(StringConvert.create(), RxAdapter.<String>create());
    }

    @Override
    public Observable<String> getComment(String itemId) {
        return OkGo.get(Api.MUSIC_COMMENT + itemId + "/0").getCall(StringConvert.create(), RxAdapter.<String>create());
    }
}