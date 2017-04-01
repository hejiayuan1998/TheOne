package com.smashing.theone.api;

/**
 * author: chensen
 * date: 2017年03月24日15:19
 * desc:
 */

public class Api {

    public static final String BASE_URL = "http://v3.wufazhuce.com:8000/api/";

    //获取最新 idlist(返回的字段用于下个接口获取某一天的onelist,一共10个返回值,也就是10天的数据)
    public static final String ID_LIST = BASE_URL + "onelist/idlist/";
    //获取某天的 onelist
    public static final String ONE_LIST = BASE_URL + "onelist/";

    //阅读列表
    public static final String READ_LIST = BASE_URL + "channel/reading/more/0";
    //音乐列表
    public static final String MUSIC_LIST = BASE_URL + "channel/music/more/0";
    //影视列表
    public static final String MOVIE_LIST = BASE_URL + "channel/movie/more/0";

    //阅读相关详情
    public static final String READ_DETAIL = BASE_URL + "essay/";
    //阅读详情（问答）
    public static final String READ_QUESTION = BASE_URL + "question/itemId";
    //音乐详情
    public static final String MUSIC_DETAIL = BASE_URL + "music/detail/";
    //影视详情
    public static final String MOVIE_DETAIL = BASE_URL + "movie/itemId/story/1/0";
    //影视详情（图片和视频）
    public static final String MOVIE_DETAIL_PIC = BASE_URL + "movie/detail/itemId";

    //阅读评论
    public static final String READ_COMMENT = BASE_URL + "comment/praiseandtime/essay/";
    //音乐评论
    public static final String MUSIC_COMMENT = BASE_URL + "comment/praiseandtime/music/";
    //影视评论
    public static final String MOVIE_COMMENT = BASE_URL + "comment/praiseandtime/movie/itemId/0";

}
