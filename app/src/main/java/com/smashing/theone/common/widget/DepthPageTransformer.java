package com.smashing.theone.common.widget;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * author: chensen
 * date: 2017年03月27日19:30
 * desc: 谷歌官方给出的ViewPager的切换动画，博客中有详细介绍  http://blog.csdn.net/lmj623565791/article/details/40411921/
 * <p>
 * 假设现在ViewPager在A页现在滑出B页，则:
 * A页的position变化就是( 0, -1]
 * B页的position变化就是[ 1 , 0 ]
 */

public class DepthPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.75f;

    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();

        if (position < -1) {// [-Infinity,-1)  已经看不到了
            // This page is way off-screen to the left.
            page.setAlpha(0);
        } else if (position <= 0) {// [-1,0]
            // Use the default slide transition when moving to the left page
            page.setAlpha(1);
            page.setTranslationX(0);
            page.setScaleX(1);
            page.setScaleY(1);
        } else if (position <= 1) { // (0,1]
            // Fade the page out.
            page.setAlpha(1 - position);

            // Counteract the default slide transition
            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            page.setAlpha(0);
        }


    }
}
