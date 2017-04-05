package com.smashing.theone.business.common;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.smashing.theone.R;
import com.smashing.theone.common.base.BaseActivity;
import com.smashing.theone.common.base.BasePresenter;
import com.smashing.theone.common.utils.ImageLoader;
import com.smashing.theone.common.widget.TitleBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;

/**
 * author: chensen
 * date: 2017年04月05日9:11
 * desc: 显示一张图片
 */

public class PicActivity extends BaseActivity {
    @Bind(R.id.title_bar)
    TitleBar titleBar;
    @Bind(R.id.photo_view)
    PhotoView photoView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_pic;
    }

    @Override
    protected void initView() {
        titleBar.showRightIcon(false);
        titleBar.setTitle("图片");
        titleBar.setOnLeftIconClickListener(new TitleBar.onLeftIconClickListener() {
            @Override
            public void onLeftIconClick(View v) {
                finish();
            }
        });


        String url = getIntent().getStringExtra("url");
        if (url == null || url.equals("")) {
            Toast.makeText(mContext, "传入的url为空", 0).show();
        } else {
            ImageLoader.showImage(mContext, url, photoView);
        }


    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
