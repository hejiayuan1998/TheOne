package com.smashing.theone.bean;

/**
 * author: chensen
 * date: 2017年03月31日9:50
 * desc: 评论
 */

public class Comment {

    private String id;
    private String quote;
    private String content;
    private String praisenum;

    private boolean isExpand = false;//是否展开

    private String device_token;
    private String del_flag;
    private String reviewed;
    private String user_info_id;

    private String input_date;
    private String created_at;
    private String updated_at;
    private String type;

    private User user;
    private User touser;

    public boolean isExpand() {
        return isExpand;
    }

    public String getId() {
        return id;
    }

    public String getQuote() {
        return quote;
    }

    public String getContent() {
        return content;
    }

    public String getPraisenum() {
        return praisenum;
    }

    public String getDevice_token() {
        return device_token;
    }

    public String getDel_flag() {
        return del_flag;
    }

    public String getReviewed() {
        return reviewed;
    }

    public String getUser_info_id() {
        return user_info_id;
    }

    public String getInput_date() {
        return input_date;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getType() {
        return type;
    }

    public User getUser() {
        return user;
    }

    public User getTouser() {
        return touser;
    }
}
