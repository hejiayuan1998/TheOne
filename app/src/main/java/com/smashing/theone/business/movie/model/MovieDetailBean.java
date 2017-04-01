package com.smashing.theone.business.movie.model;

import com.smashing.theone.bean.Author;

import java.util.ArrayList;

/**
 * author: chensen
 * date: 2017年03月31日17:57
 * desc:
 */

public class MovieDetailBean {
    private int res;
    private DataBean data;

    public class DataBean {

        private ArrayList<Data> data;

        public class Data {
            private String id;
            private String movie_id;
            private String title;
            private String content;

            private String sort;
            private String praisenum;
            private String input_date;
            private String story_type;

            private String summary;
            private String audio;
            private String anchor;
            private String copyright;


            private String charge_edt;
            private String editor_email;

            private Author user;

            public String getId() {
                return id;
            }

            public String getMovie_id() {
                return movie_id;
            }

            public String getTitle() {
                return title;
            }

            public String getContent() {
                return content;
            }

            public String getSort() {
                return sort;
            }

            public String getPraisenum() {
                return praisenum;
            }

            public String getInput_date() {
                return input_date;
            }

            public String getStory_type() {
                return story_type;
            }

            public String getSummary() {
                return summary;
            }

            public String getAudio() {
                return audio;
            }

            public String getAnchor() {
                return anchor;
            }

            public String getCopyright() {
                return copyright;
            }

            public String getCharge_edt() {
                return charge_edt;
            }

            public String getEditor_email() {
                return editor_email;
            }

            public Author getUser() {
                return user;
            }
        }

        public ArrayList<Data> getData() {
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
