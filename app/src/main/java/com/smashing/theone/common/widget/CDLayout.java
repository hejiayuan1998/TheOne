package com.smashing.theone.common.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.smashing.theone.R;

/**
 * author: chensen
 * date: 2017年04月06日9:46
 * desc:
 */

public class CDLayout extends FrameLayout {

    private ImageView ivPic;
    private ImageView ivPlay;
    private ImageView ivStop;

    private boolean isPlaying;
    private float lastRoate = 0;//旋转的角度

    public onPlayListener onPlayListener;
    public onStopListener onStopListener;

    ObjectAnimator rotation;

    public CDLayout(@NonNull Context context) {
        this(context, null);
    }

    public CDLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CDLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View view = LayoutInflater.from(context).inflate(R.layout.item_cd_layout, this, false);
        addView(view);


        ivPic = (ImageView) view.findViewById(R.id.iv_pic);
        ivPlay = (ImageView) view.findViewById(R.id.iv_play);
        ivStop = (ImageView) view.findViewById(R.id.iv_stop);

        ivPlay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                isPlaying = true;

                ivStop.setVisibility(VISIBLE);
                ivPlay.setVisibility(GONE);

                if (onPlayListener != null) {
                    onPlayListener.onPlay();
                }

                startAnim();
            }
        });
        ivStop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                isPlaying = false;
                ivStop.setVisibility(GONE);
                ivPlay.setVisibility(VISIBLE);
                if (onStopListener != null) {
                    onStopListener.onStop();
                }
                stopAnim();
            }
        });
    }

    public void startAnim() {
        rotation = ObjectAnimator.ofFloat(ivPic, "rotation", lastRoate, lastRoate + 360);
        rotation.setDuration(36000);
        rotation.setRepeatMode(ValueAnimator.RESTART);
        rotation.setRepeatCount(ValueAnimator.INFINITE);
        rotation.setInterpolator(new LinearInterpolator());


        rotation.start();
    }

    private void stopAnim() {
        lastRoate = (float) rotation.getAnimatedValue();
        rotation.cancel();
    }

    //继续播放
    public void continuePlay() {
        startAnim();

        ivPlay.setVisibility(GONE);
        ivStop.setVisibility(VISIBLE);
    }

    //重置状态
    public void reSet() {
        if (rotation != null) {
            Log.d("tag", "rotation.cancel()");
            rotation.cancel();
        }
        ivPic.clearAnimation();
        ivPic.setRotation(0);

        ivPlay.setVisibility(VISIBLE);
        ivStop.setVisibility(GONE);
    }


    public interface onPlayListener {
        void onPlay();
    }

    public interface onStopListener {
        void onStop();
    }


    public void setOnPlayListener(onPlayListener listener) {
        this.onPlayListener = listener;
    }

    public void setStopListener(onStopListener listener) {
        this.onStopListener = listener;
    }


    public ImageView getIvPic() {
        return ivPic;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public float getRotation() {
        return lastRoate;
    }


}
