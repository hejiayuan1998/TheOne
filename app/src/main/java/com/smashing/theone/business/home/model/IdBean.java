package com.smashing.theone.business.home.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * author: chensen
 * date: 2017年03月25日16:08
 * desc:
 */

public class IdBean implements Serializable {

    private String res;
    private ArrayList<String> data;

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }
}
