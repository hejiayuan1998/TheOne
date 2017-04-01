package com.smashing.theone.business.read.contract;

import com.smashing.theone.bean.Content;
import com.smashing.theone.common.base.BaseModel;
import com.smashing.theone.common.base.BaseView;

import java.util.ArrayList;

import rx.Observable;

/**
 * author: chensen
 * date: 2017年03月28日8:58
 * desc:
 */

public class ReadContract {

    public interface View  extends BaseView{

        void showList(ArrayList<Content> listData);

    }

    public interface Presenter {

        void getList();
        String getItemId(int position);

    }

    public interface Model extends BaseModel {
        Observable<String> getList();
    }


}