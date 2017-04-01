package com.smashing.theone.business.music.model;

import com.smashing.theone.bean.Author;

/**
 * author: chensen
 * date: 2017年03月30日16:48
 * desc:
 */

public class MusicDetailBean {
    private int res;
    private MusicDetailData data;

    public class MusicDetailData {
        private String id;
        private String title;
        private String cover;
        private String isfirst;

        private String story_title;
        private String story;
        private String lyric;
        private String info;


        private String music_id;
        private String platform;
        private String charge_edt;
        private String related_to;


        private String web_url;
        private String praisenum;
        private String hide_flag;
        private String sort;

        private String maketime;
        private String last_update_date;
        private String read_num;
        private String story_summary;

        private String audio;
        private String anchor;
        private String editor_email;
        private String related_musics;

        private String album;
        private String start_video;
        private String media_type;
        private String copyright;

        private String next_id;
        private String previous_id;
        private String sharenum;
        private String commentnum;

        private Author author;
        private Author story_author;

        public Author getStory_author() {
            return story_author;
        }

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getCover() {
            return cover;
        }

        public String getIsfirst() {
            return isfirst;
        }

        public String getStory_title() {
            return story_title;
        }

        public String getStory() {
            return story;
        }

        public String getLyric() {
            return lyric;
        }

        public String getInfo() {
            return info;
        }

        public String getMusic_id() {
            return music_id;
        }

        public String getPlatform() {
            return platform;
        }

        public String getCharge_edt() {
            return charge_edt;
        }

        public String getRelated_to() {
            return related_to;
        }

        public String getWeb_url() {
            return web_url;
        }

        public String getPraisenum() {
            return praisenum;
        }

        public String getHide_flag() {
            return hide_flag;
        }

        public String getSort() {
            return sort;
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

        public String getStory_summary() {
            return story_summary;
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

        public String getRelated_musics() {
            return related_musics;
        }

        public String getAlbum() {
            return album;
        }

        public String getStart_video() {
            return start_video;
        }

        public String getMedia_type() {
            return media_type;
        }

        public String getCopyright() {
            return copyright;
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

        public Author getAuthor() {
            return author;
        }
    }

    public int getRes() {
        return res;
    }

    public MusicDetailData getData() {
        return data;
    }
}
