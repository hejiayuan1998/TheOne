package com.smashing.theone.business.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.smashing.theone.R;
import com.smashing.theone.common.base.BaseActivity;
import com.smashing.theone.common.base.BasePresenter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: chensen
 * date: 2017年04月06日11:12
 * desc: 启动也
 */

public class LaunchActivity extends BaseActivity {
    @Bind(R.id.iv_pic)
    ImageView ivPic;
    @Bind(R.id.tv_data)
    TextView tvData;

    Timer timer;

    @Override
    public int getLayoutId() {
        return R.layout.activity_launch;
    }

    @Override
    protected void initView() {
        timer = new Timer();
        getData();


        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(3000);

        ivPic.startAnimation(scaleAnimation);


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(mContext, MainActivity.class));
                finish();
            }
        }, 3000);

    }

    private void getData() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String data = simpleDateFormat.format(new Date());
        tvData.setText(data);

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
