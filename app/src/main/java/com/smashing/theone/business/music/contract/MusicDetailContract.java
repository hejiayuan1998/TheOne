package com.smashing.theone.business.music.contract;

import com.smashing.theone.bean.Comment;
import com.smashing.theone.business.music.model.MusicDetailBean;
import com.smashing.theone.common.base.BaseModel;
import com.smashing.theone.common.base.BaseView;

import java.util.ArrayList;

import rx.Observable;

/**
 * author: chensen
 * date: 2017年03月30日16:48
 * desc:
 */

public class MusicDetailContract {

    public interface View extends BaseView {

        void showContent(MusicDetailBean.MusicDetailData data);

        void showComment(ArrayList<Comment> listConment);

    }

    public interface Presenter {
        void getContent(String itemId);

        void getComment(String itemId);

        void getMusic();

    }

    public interface Model extends BaseModel {
        Observable<String> getContent(String itemId);

        Observable<String> getComment(String itemId);
    }


}