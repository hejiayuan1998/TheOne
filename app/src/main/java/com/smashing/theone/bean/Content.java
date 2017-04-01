package com.smashing.theone.bean;

import java.util.ArrayList;

/**
 * author: chensen
 * date: 2017年03月28日9:15
 * desc: ontlist,阅读，音乐，影视  的通用列表内容
 */

public class Content {
    private String id;
    private String category;
    private String display_category;
    private String item_id;

    private String title;
    private String forward;
    private String img_url;
    private String like_count;

    private String post_date;
    private String last_update_date;
    private String video_url;
    private String audio_url;

    private String audio_platform;
    private String start_video;
    private String volume;
    private String pic_info;

    private String words_info;
    private String subtitle;
    private String number;
    private String serial_id;

    private String movie_story_id;
    private String ad_id;
    private String ad_type;
    private String ad_pvurl;

    private String ad_linkurl;
    private String ad_makettime;
    private String ad_closetime;
    private String ad_share_cnt;


    private String ad_pvurl_vendor;
    private String content_id;
    private String content_type;
    private String content_bgcolor;

    private String share_url;
    private String orientation;
    private String music_name;//歌名
    private String audio_author;
    private String audio_album;//专辑


    private Author author;   //作者信息
    private ShareInfo share_info;   //分享信息
    private ArrayList<String> serial_list;
    private Answerer answerer;
    private ArrayList<Tag> tag_list;




    //分享
    public class ShareInfo {

        private String url;
        private String image;
        private String title;
        private String content;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    //问答
    public class Answerer {
        private String user_id;
        private String user_name;
        private String web_url;
        private String summary;

        private String desc;
        private String is_settled;
        private String settled_type;
        private String fans_tota;
        private String wb_name;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getIs_settled() {
            return is_settled;
        }

        public void setIs_settled(String is_settled) {
            this.is_settled = is_settled;
        }

        public String getSettled_type() {
            return settled_type;
        }

        public void setSettled_type(String settled_type) {
            this.settled_type = settled_type;
        }

        public String getFans_tota() {
            return fans_tota;
        }

        public void setFans_tota(String fans_tota) {
            this.fans_tota = fans_tota;
        }

        public String getWb_name() {
            return wb_name;
        }

        public void setWb_name(String wb_name) {
            this.wb_name = wb_name;
        }
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDisplay_category() {
        return display_category;
    }

    public void setDisplay_category(String display_category) {
        this.display_category = display_category;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getForward() {
        return forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getLike_count() {
        return like_count;
    }

    public void setLike_count(String like_count) {
        this.like_count = like_count;
    }

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }

    public String getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(String last_update_date) {
        this.last_update_date = last_update_date;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getAudio_url() {
        return audio_url;
    }

    public void setAudio_url(String audio_url) {
        this.audio_url = audio_url;
    }

    public String getAudio_platform() {
        return audio_platform;
    }

    public void setAudio_platform(String audio_platform) {
        this.audio_platform = audio_platform;
    }

    public String getStart_video() {
        return start_video;
    }

    public void setStart_video(String start_video) {
        this.start_video = start_video;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPic_info() {
        return pic_info;
    }

    public void setPic_info(String pic_info) {
        this.pic_info = pic_info;
    }

    public String getWords_info() {
        return words_info;
    }

    public void setWords_info(String words_info) {
        this.words_info = words_info;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSerial_id() {
        return serial_id;
    }

    public void setSerial_id(String serial_id) {
        this.serial_id = serial_id;
    }

    public String getMovie_story_id() {
        return movie_story_id;
    }

    public void setMovie_story_id(String movie_story_id) {
        this.movie_story_id = movie_story_id;
    }

    public String getAd_id() {
        return ad_id;
    }

    public void setAd_id(String ad_id) {
        this.ad_id = ad_id;
    }

    public String getAd_type() {
        return ad_type;
    }

    public void setAd_type(String ad_type) {
        this.ad_type = ad_type;
    }

    public String getAd_pvurl() {
        return ad_pvurl;
    }

    public void setAd_pvurl(String ad_pvurl) {
        this.ad_pvurl = ad_pvurl;
    }

    public String getAd_linkurl() {
        return ad_linkurl;
    }

    public void setAd_linkurl(String ad_linkurl) {
        this.ad_linkurl = ad_linkurl;
    }

    public String getAd_makettime() {
        return ad_makettime;
    }

    public void setAd_makettime(String ad_makettime) {
        this.ad_makettime = ad_makettime;
    }

    public String getAd_closetime() {
        return ad_closetime;
    }

    public void setAd_closetime(String ad_closetime) {
        this.ad_closetime = ad_closetime;
    }

    public String getAd_share_cnt() {
        return ad_share_cnt;
    }

    public void setAd_share_cnt(String ad_share_cnt) {
        this.ad_share_cnt = ad_share_cnt;
    }

    public String getAd_pvurl_vendor() {
        return ad_pvurl_vendor;
    }

    public void setAd_pvurl_vendor(String ad_pvurl_vendor) {
        this.ad_pvurl_vendor = ad_pvurl_vendor;
    }

    public String getContent_id() {
        return content_id;
    }

    public void setContent_id(String content_id) {
        this.content_id = content_id;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getContent_bgcolor() {
        return content_bgcolor;
    }

    public void setContent_bgcolor(String content_bgcolor) {
        this.content_bgcolor = content_bgcolor;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getMusic_name() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }

    public String getAudio_author() {
        return audio_author;
    }

    public void setAudio_author(String audio_author) {
        this.audio_author = audio_author;
    }

    public String getAudio_album() {
        return audio_album;
    }

    public void setAudio_album(String audio_album) {
        this.audio_album = audio_album;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public ShareInfo getShare_info() {
        return share_info;
    }

    public void setShare_info(ShareInfo share_info) {
        this.share_info = share_info;
    }

    public ArrayList<String> getSerial_list() {
        return serial_list;
    }

    public void setSerial_list(ArrayList<String> serial_list) {
        this.serial_list = serial_list;
    }

    public Answerer getAnswerer() {
        return answerer;
    }

    public void setAnswerer(Answerer answerer) {
        this.answerer = answerer;
    }

    public ArrayList<Tag> getTag_list() {
        return tag_list;
    }

    public void setTag_list(ArrayList<Tag> tag_list) {
        this.tag_list = tag_list;
    }
}
