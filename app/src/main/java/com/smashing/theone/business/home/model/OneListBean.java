package com.smashing.theone.business.home.model;

import com.smashing.theone.bean.Content;
import com.smashing.theone.bean.Weather;

import java.util.ArrayList;

/**
 * author: chensen
 * date: 2017年03月25日16:32
 * desc:
 */


public class OneListBean {
    //content_list 是一个链表，size 是7，这7个信息不属于同一个类别
    /**
     * category字段表示类别:
     * 0:摄影  插画
     * 1：阅读  漫画 one实验室 一周语文 onstory
     * 2：连载
     * 3：问答
     * 4：音乐  深夜电台
     * 5：影视 视频
     */

    private int res;
    private DataBean data;

    public class DataBean {

        private String id;
        private String date;
        private Weather weather;
        private ArrayList<Content> content_list;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Weather getWeather() {
            return weather;
        }

        public void setWeather(Weather weather) {
            this.weather = weather;
        }

        public ArrayList<Content> getContent_list() {
            return content_list;
        }

        public void setContent_list(ArrayList<Content> content_list) {
            this.content_list = content_list;
        }
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }
}
