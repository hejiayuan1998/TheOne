package com.smashing.theone.business.movie.contract;

import com.smashing.theone.bean.Content;
import com.smashing.theone.common.base.BaseModel;
import com.smashing.theone.common.base.BaseView;

import java.util.ArrayList;

import rx.Observable;

/**
 * author: chensen
 * date: 2017年03月25日15:28
 * desc:
 */

public class MovieContract {

    public interface View  extends BaseView{

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