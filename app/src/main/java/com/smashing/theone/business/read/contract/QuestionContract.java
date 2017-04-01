package com.smashing.theone.business.read.contract;

import com.smashing.theone.business.read.model.QuestionBean;
import com.smashing.theone.common.base.BaseModel;
import com.smashing.theone.common.base.BaseView;

import rx.Observable;

/**
 * author: chensen
 * date: 2017年04月01日11:34
 * desc:
 */

public class QuestionContract {

    public interface View extends BaseView {
        void showContent(QuestionBean.QusetionBeanData data);
    }

    public interface Presenter {
        void getContent(String itemId);
    }

    public interface Model extends BaseModel {
        Observable<String> getContent(String itemId);
    }


}