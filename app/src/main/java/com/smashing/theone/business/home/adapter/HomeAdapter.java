package com.smashing.theone.business.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.smashing.theone.business.home.view.OneListFragment;

import java.util.ArrayList;

/**
 * author: chensen
 * date: 2017年03月27日8:19
 * desc:
 */

public class HomeAdapter extends FragmentPagerAdapter {
    ArrayList<OneListFragment> listFragments;

    public HomeAdapter(FragmentManager fm, ArrayList<OneListFragment> listFragments) {
        super(fm);
        this.listFragments = listFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }
}
