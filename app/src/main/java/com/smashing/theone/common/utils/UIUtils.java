package com.smashing.theone.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.smashing.theone.app.TheOne;

import java.io.InputStream;

/**
 * author: chensen
 * date: 2017年03月27日11:43
 * desc:
 */

public class UIUtils {

    public static Context getContext() {
        return TheOne.getContext();
    }

    public static Resources getResources() {
        return getContext().getResources();
    }

    public static String getString(int resId) {
        return getResources().getString(resId);
    }

    public static String[] getStringArray(int resId) {
        return getResources().getStringArray(resId);
    }

    public static String getPackageName() {
        return getContext().getPackageName();
    }

    public static int getColor(int resId) {
        return getResources().getColor(resId);
    }

    public static Handler getMainHandler() {
        return TheOne.getMainHandler();
    }

    /**
     * dip 转 px
     *
     * @param dip
     * @return
     */
    public static int dip2px(int dip) {
        //
        // 公式： dp = px / (dpi / 160) px = dp * (dpi / 160)
        // dp = px / denisity
        // px = dp * denisity;
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float density = metrics.density;
        return (int) (dip * density + 0.5f);
    }

    public static int px2dip(int px) {
        // dp = px / denisity
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float density = metrics.density;
        return (int) (px / density + 0.5f);
    }

    /**
     * 隐藏软键盘
     *
     * @param context
     */
    public static void hideKeyBoard(Activity context) {
        if (context != null && context.getCurrentFocus() != null) {
            ((InputMethodManager) context
                    .getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(context.getCurrentFocus()
                                    .getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    /**
     * 获取屏幕分辨率
     *
     * @param context
     * @return
     */
    public static int[] getScreenDispaly(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = windowManager.getDefaultDisplay().getWidth();// 手机屏幕的宽度
        int height = windowManager.getDefaultDisplay().getHeight();// 手机屏幕的高度
        int result[] = {width, height};
        return result;
    }


    public static String readAssert(Context context, String fileName) {
        String jsonString = "";
        String resultString = "";
        try {
            InputStream inputStream = context.getResources().getAssets().open(fileName);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            resultString = new String(buffer, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }

    public static void refresh(final LRecyclerView mRecyclerView, final LRecyclerViewAdapter mLRecyclerViewAdapter) {
        UIUtils.getMainHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mRecyclerView != null) {
                    mRecyclerView.refreshComplete(10);
                    //此处刷新会与BaseAdapter中设置数据后的刷新重复，导致页面闪烁，故屏蔽掉
                   // mLRecyclerViewAdapter.notifyDataSetChanged();
                }
            }
        }, 1000);
    }
}
