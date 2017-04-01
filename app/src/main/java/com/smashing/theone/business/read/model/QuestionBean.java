package com.smashing.theone.business.read.model;

import com.smashing.theone.bean.Author;

/**
 * author: chensen
 * date: 2017年04月01日11:38
 * desc:
 */

public class QuestionBean {
    private int res;
    private QusetionBeanData data;

    public class QusetionBeanData {
        private String question_id;
        private String question_title;
        private String question_content;
        private String answer_title;

        private String answer_content;
        private String question_makettime;
        private String recommend_flag;
        private String charge_edt;

        private String last_update_date;
        private String web_url;
        private String read_num;
        private String guide_word;

        private String praisenum;
        private String sharenum;
        private String commentnum;
        private String copyright;

        private Author answerer;
        private Author asker;

        public String getCopyright() {
            return copyright;
        }

        public String getQuestion_id() {
            return question_id;
        }

        public String getQuestion_title() {
            return question_title;
        }

        public String getQuestion_content() {
            return question_content;
        }

        public String getAnswer_title() {
            return answer_title;
        }

        public String getAnswer_content() {
            return answer_content;
        }

        public String getQuestion_makettime() {
            return question_makettime;
        }

        public String getRecommend_flag() {
            return recommend_flag;
        }

        public String getCharge_edt() {
            return charge_edt;
        }

        public String getLast_update_date() {
            return last_update_date;
        }

        public String getWeb_url() {
            return web_url;
        }

        public String getRead_num() {
            return read_num;
        }

        public String getGuide_word() {
            return guide_word;
        }

        public String getPraisenum() {
            return praisenum;
        }

        public String getSharenum() {
            return sharenum;
        }

        public String getCommentnum() {
            return commentnum;
        }

        public Author getAnswerer() {
            return answerer;
        }

        public Author getAsker() {
            return asker;
        }
    }

    public int getRes() {
        return res;
    }

    public QusetionBeanData getData() {
        return data;
    }
}
