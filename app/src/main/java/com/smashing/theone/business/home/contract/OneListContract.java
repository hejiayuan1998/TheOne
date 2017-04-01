package com.smashing.theone.business.home.contract;

import com.smashing.theone.bean.Content;
import com.smashing.theone.bean.Weather;
import com.smashing.theone.common.base.BaseModel;
import com.smashing.theone.common.base.BaseView;

import java.util.ArrayList;

import rx.Observable;

/**
 * author: chensen
 * date: 2017年03月27日8:21
 * desc:
 */

public class OneListContract {


    public interface View extends BaseView {

        void showWeather(Weather weather,String date);
        void showOneList(ArrayList<Content> listData);
    }

    public interface Presenter {
        void getOneList(String id);
    }

    public interface Model extends BaseModel {
        Observable<String> getIdList();

        Observable<String> getOneList(String id);
    }
}
