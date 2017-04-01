package com.smashing.theone.common.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * author: chensen
 * date: 2017年03月23日17:27
 * desc: 加载图片的工具类
 */

public class ImageLoader {

    public static void showImage(Context context, String url, ImageView view) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .animate(android.R.anim.fade_in)
//                .placeholder() //占位
//                .error() //加载失败
                .into(view);

    }
    public static void showImage(Context context, String url, ImageView view,int error) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .animate(android.R.anim.fade_in)
//                .placeholder() //占位
                .error(error) //加载失败
                .into(view);

    }

}
