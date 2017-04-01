package com.smashing.theone.business.read.model;

import com.smashing.theone.bean.Author;
import com.smashing.theone.bean.Tag;

import java.util.ArrayList;

/**
 * author: chensen
 * date: 2017年03月30日8:31
 * desc:
 */

public class ReadDetailBean {

    private int res;
    private DataBean data;

    public class DataBean {
        private String content_id;
        private String hp_title;
        private String sub_title;
        private String hp_author;

        private String auth_it;
        private String hp_author_introduce;
        private String hp_content;
        private String hp_makettime;

        private String hide_flag;
        private String wb_name;
        private String wb_img_url;
        private String last_update_date;

        private String web_url;
        private String guide_word;
        private String audio;
        private String anchor;

        private String editor_email;
        private String top_media_file;
        private String top_media_type;
        private String top_media_image;

        private String start_video;
        private String copyright;
        private String maketime;
        private String next_id;

        private String previous_id;
        private String praisenum;
        private String sharenum;
        private String commentnum;

        private ArrayList<Author> author;
        private ArrayList<Tag> tag_list;

        public ArrayList<Tag> getTag_list() {
            return tag_list;
        }

        public String getContent_id() {
            return content_id;
        }

        public String getHp_title() {
            return hp_title;
        }

        public String getSub_title() {
            return sub_title;
        }

        public String getHp_author() {
            return hp_author;
        }

        public String getAuth_it() {
            return auth_it;
        }

        public String getHp_author_introduce() {
            return hp_author_introduce;
        }

        public String getHp_content() {
            return hp_content;
        }

        public String getHp_makettime() {
            return hp_makettime;
        }

        public String getHide_flag() {
            return hide_flag;
        }

        public String getWb_name() {
            return wb_name;
        }

        public String getWb_img_url() {
            return wb_img_url;
        }

        public String getLast_update_date() {
            return last_update_date;
        }

        public String getWeb_url() {
            return web_url;
        }

        public String getGuide_word() {
            return guide_word;
        }

        public String getAudio() {
            return audio;
        }

        public String getAnchor() {
            return anchor;
        }

        public String getEditor_email() {
            return editor_email;
        }

        public String getTop_media_file() {
            return top_media_file;
        }

        public String getTop_media_type() {
            return top_media_type;
        }

        public String getTop_media_image() {
            return top_media_image;
        }

        public String getStart_video() {
            return start_video;
        }

        public String getCopyright() {
            return copyright;
        }

        public String getMaketime() {
            return maketime;
        }

        public String getNext_id() {
            return next_id;
        }

        public String getPrevious_id() {
            return previous_id;
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

        public ArrayList<Author> getAuthor() {
            return author;
        }
    }

    public int getRes() {
        return res;
    }

    public DataBean getData() {
        return data;
    }
}
