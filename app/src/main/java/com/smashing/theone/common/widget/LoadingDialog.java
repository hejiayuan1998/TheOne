package com.smashing.theone.common.widget;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.smashing.theone.R;

/**
 * author: chensen
 * date: 2017年03月29日8:36
 * desc:
 */

public class LoadingDialog {
    private static Dialog mLoadingDialog;

    public static Dialog showLoadingDialog(Activity context, String msg, boolean cancelable) {

        View view = LayoutInflater.from(context).inflate(R.layout.loading_dialog_layout, null);
        ImageView ivAnim = (ImageView) view.findViewById(R.id.iv_anim);
        TextView tvText = (TextView) view.findViewById(R.id.tv_text);
        tvText.setText(msg);

        mLoadingDialog = new Dialog(context, R.style.CustomProgressDialog);
        mLoadingDialog.setCancelable(cancelable);
        mLoadingDialog.setCanceledOnTouchOutside(false);
        mLoadingDialog.setContentView(view);
        mLoadingDialog.show();
        ((AnimationDrawable) ivAnim.getDrawable()).start();
        return mLoadingDialog;

    }

    public static Dialog showLoadingDialog(Activity context) {
        Log.d("tag","创建");


        View view = LayoutInflater.from(context).inflate(R.layout.loading_dialog_layout, null);
        ImageView ivAnim = (ImageView) view.findViewById(R.id.iv_anim);
        TextView tvText = (TextView) view.findViewById(R.id.tv_text);
        tvText.setText("加载中...");

        mLoadingDialog = new Dialog(context, R.style.CustomProgressDialog);
        mLoadingDialog.setCancelable(true);
        mLoadingDialog.setCanceledOnTouchOutside(false);
        mLoadingDialog.setContentView(view);
        mLoadingDialog.show();
        ((AnimationDrawable) ivAnim.getDrawable()).start();
        return mLoadingDialog;
    }

    public static void cancleDialog() {
        Log.d("tag","取消");
        if (mLoadingDialog != null) {
            Log.d("tag","真正取消");
            mLoadingDialog.cancel();
        }
    }

}
