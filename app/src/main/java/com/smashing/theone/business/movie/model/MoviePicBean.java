package com.smashing.theone.business.movie.model;

import java.util.ArrayList;

/**
 * author: chensen
 * date: 2017年04月01日8:38
 * desc:
 */

public class MoviePicBean {
    private int res;
    private PicData data;

    public class PicData {

        private String id;
        private String title;
        private String indexcover;
        private String detailcover;

        private String video;
        private String verse;
        private String verse_en;
        private String score;

        private String revisedscore;
        private String review;
        private String keywords;
        private String movie_id;

        private String info;
        private String officialstory;
        private String hide_flag;
        private String charge_edt;

        private String web_url;
        private String praisenum;
        private String sort;
        private String releasetime;

        private String scoretime;
        private String maketime;
        private String last_update_date;
        private String read_num;

        private String directors;
        private String editor_email;
        private String related;
        private String directors_id;

        private String start_video;
        private String media_type;
        private String poster;
        private String next_id;

        private String previous_id;
        private String sharenum;
        private String commentnum;
        private String servertime;

        private ArrayList<String> photo;

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getIndexcover() {
            return indexcover;
        }

        public String getDetailcover() {
            return detailcover;
        }

        public String getVideo() {
            return video;
        }

        public String getVerse() {
            return verse;
        }

        public String getVerse_en() {
            return verse_en;
        }

        public String getScore() {
            return score;
        }

        public String getRevisedscore() {
            return revisedscore;
        }

        public String getReview() {
            return review;
        }

        public String getKeywords() {
            return keywords;
        }

        public String getMovie_id() {
            return movie_id;
        }

        public String getInfo() {
            return info;
        }

        public String getOfficialstory() {
            return officialstory;
        }

        public String getHide_flag() {
            return hide_flag;
        }

        public String getCharge_edt() {
            return charge_edt;
        }

        public String getWeb_url() {
            return web_url;
        }

        public String getPraisenum() {
            return praisenum;
        }

        public String getSort() {
            return sort;
        }

        public String getReleasetime() {
            return releasetime;
        }

        public String getScoretime() {
            return scoretime;
        }

        public String getMaketime() {
            return maketime;
        }

        public String getLast_update_date() {
            return last_update_date;
        }

        public String getRead_num() {
            return read_num;
        }

        public String getDirectors() {
            return directors;
        }

        public String getEditor_email() {
            return editor_email;
        }

        public String getRelated() {
            return related;
        }

        public String getDirectors_id() {
            return directors_id;
        }

        public String getStart_video() {
            return start_video;
        }

        public String getMedia_type() {
            return media_type;
        }

        public String getPoster() {
            return poster;
        }

        public String getNext_id() {
            return next_id;
        }

        public String getPrevious_id() {
            return previous_id;
        }

        public String getSharenum() {
            return sharenum;
        }

        public String getCommentnum() {
            return commentnum;
        }

        public String getServertime() {
            return servertime;
        }

        public ArrayList<String> getPhoto() {
            return photo;
        }
    }

    public int getRes() {
        return res;
    }

    public PicData getData() {
        return data;
    }
}
