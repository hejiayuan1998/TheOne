package com.smashing.theone.business.movie.contract;

import com.smashing.theone.bean.Comment;
import com.smashing.theone.business.movie.model.MovieDetailBean;
import com.smashing.theone.business.movie.model.MoviePicBean;
import com.smashing.theone.common.base.BaseModel;
import com.smashing.theone.common.base.BaseView;

import java.util.ArrayList;

import rx.Observable;

/**
 * author: chensen
 * date: 2017年03月31日17:54
 * desc:
 */

public class MovieDetailContract {

    public interface View extends BaseView {

        void showPic(MoviePicBean.PicData data);
        void showContent(MovieDetailBean.DataBean.Data data);

        void showComment(ArrayList<Comment> listConment);
    }

    public interface Presenter {
        void getPic(String itemId);

        void getContent(String itemId);

        void getComment(String itemId);
    }

    public interface Model extends BaseModel {
        Observable<String> getPic(String itemId);
        Observable<String> getContent(String itemId);

        Observable<String> getComment(String itemId);
    }


}