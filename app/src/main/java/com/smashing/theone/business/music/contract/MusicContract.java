package com.smashing.theone.business.music.contract;

import com.smashing.theone.bean.Content;
import com.smashing.theone.common.base.BaseModel;
import com.smashing.theone.common.base.BaseView;

import java.util.ArrayList;

import rx.Observable;

/**
 * author: chensen
 * date: 2017年03月28日10:44
 * desc:
 */

public class MusicContract {

    public interface View extends BaseView {

        void showList(ArrayList<Content> listData);

    }

    public interface Presenter {

        void getList();
        String  getItemId(int position);

    }

    public interface Model extends BaseModel {
        Observable<String> getList();
    }


}