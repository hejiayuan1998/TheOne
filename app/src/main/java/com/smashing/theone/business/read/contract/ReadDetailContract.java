package com.smashing.theone.business.read.contract;

import com.smashing.theone.bean.Comment;
import com.smashing.theone.business.read.model.ReadDetailBean;
import com.smashing.theone.common.base.BaseModel;
import com.smashing.theone.common.base.BaseView;

import java.util.ArrayList;

import rx.Observable;

/**
 * author: chensen
 * date: 2017年03月30日8:30
 * desc:
 */

public class ReadDetailContract {

    public interface View extends BaseView {
        void showContent(ReadDetailBean bean);
        void showComment(ArrayList<Comment> listConment);
    }

    public interface Presenter {
        void getDetail(String itemId);
        void getComment(String itemId);
    }

    public interface Model extends BaseModel {
        Observable<String> getDetail(String itemId);
        Observable<String> getComment(String itemId);

    }


}