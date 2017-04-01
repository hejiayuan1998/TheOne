package com.smashing.theone.bean;

import java.util.ArrayList;

/**
 * author: chensen
 * date: 2017年03月31日9:48
 * desc:
 */

public class CommentBean {
    private int res;

    private DataBean data;

    public  class DataBean {

        private int count;
        private ArrayList<Comment> data;

        public int getCount() {
            return count;
        }

        public ArrayList<Comment> getData() {
            return data;
        }



    }

    public int getRes() {
        return res;
    }

    public DataBean getData() {
        return data;
    }
}
