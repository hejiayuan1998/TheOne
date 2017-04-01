package com.smashing.theone.business.movie.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * author: chensen
 * date: 2017年04月01日10:25
 * desc:
 */

public class MoviePicAdapter extends PagerAdapter {

    ArrayList<View> listView = new ArrayList<>();


    public MoviePicAdapter(ArrayList<View> listView) {
        this.listView = listView;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(listView.get(position));
        return listView.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(listView.get(position));
    }


    @Override
    public int getCount() {
        return listView.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
