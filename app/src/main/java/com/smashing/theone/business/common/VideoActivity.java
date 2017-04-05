package com.smashing.theone.business.common;

import android.net.Uri;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.smashing.theone.R;
import com.smashing.theone.common.base.BaseActivity;
import com.smashing.theone.common.base.BasePresenter;
import com.smashing.theone.common.widget.TitleBar;

import butterknife.Bind;

/**
 * author: chensen
 * date: 2017年04月05日10:40
 * desc: 播放视频
 */

public class VideoActivity extends BaseActivity {
    @Bind(R.id.title_bar)
    TitleBar titleBar;
    @Bind(R.id.video_view)
    VideoView videoView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_video;
    }

    @Override
    protected void initView() {

        titleBar.setTitle("视频");
        titleBar.showRightIcon(false);
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
            videoView.setVideoURI(Uri.parse(url));
            videoView.setMediaController(new MediaController(this));
            videoView.start();
        }

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

}

