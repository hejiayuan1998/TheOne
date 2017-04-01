package com.smashing.theone.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.IRefreshHeader;
import com.smashing.theone.R;

/**
 * author: chensen
 * date: 2017年03月28日14:35
 * desc:
 */

public class ReadingRefreshHeader extends LinearLayout implements IRefreshHeader {

    private RelativeLayout rlContainer;

    private TextView tvStatus;
    private ImageView ivAnim;

    public int mMeasuredHeight;

    private int mState = STATE_NORMAL;


    public ReadingRefreshHeader(Context context) {
        super(context);
        initView(context);
    }


    public ReadingRefreshHeader(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }


    public ReadingRefreshHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, 0);
        this.setLayoutParams(params);
        this.setPadding(0, 0, 0, 0);

        // 初始情况，设置下拉刷新view高度为0
        rlContainer = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.reading_refresh_header, this, false);
        addView(rlContainer, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0));
        setGravity(Gravity.BOTTOM);


        tvStatus = (TextView) findViewById(R.id.tv_status);
        ivAnim = (ImageView) findViewById(R.id.iv_anim);

        measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mMeasuredHeight = getMeasuredHeight();
        //Log.d("tag", "mMeasuredHeight-->" + mMeasuredHeight);
    }


    @Override
    public void onReset() {
        Log.d("tag", "onReset");
        mState = STATE_NORMAL;
    }

    /**
     * 处于可以刷新的状态，已经过了指定距离
     */
    @Override
    public void onPrepare() {
        Log.d("tag", "onPrepare");
    }

    /**
     * 正在刷新
     */
    @Override
    public void onRefreshing() {
        Log.d("tag", "onRefreshing");

    }

    /**
     * 下拉移动
     */
    @Override
    public void onMove(float offSet, float sumOffSet) {
        if (getVisibleHeight() > 0 || offSet > 0) {
            setVisibleHeight((int) (offSet + getVisibleHeight()));
            if (getVisibleHeight() > mMeasuredHeight) {
                mState = STATE_RELEASE_TO_REFRESH;
                tvStatus.setText("释放立即刷新");
            } else {
                mState = STATE_NORMAL;
                tvStatus.setText("下拉刷新");
            }

        }
    }

    /**
     * 下拉松开
     */
    @Override
    public boolean onRelease() {
        Log.d("tag", "onRelease");
        boolean isOnRefresh = false;
        int height = getVisibleHeight();

        if (height > mMeasuredHeight) {
            isOnRefresh = true;
            if (mState != STATE_REFRESHING) {//如果已经处于刷新状态，就不再次调用
                ivAnim.clearAnimation();
                ((AnimationDrawable) ivAnim.getDrawable()).start();
            }
            tvStatus.setText("正在刷新...");
            smoothScrollTo(mMeasuredHeight);
            mState = STATE_REFRESHING;
        } else {
            isOnRefresh = false;
            ((AnimationDrawable) ivAnim.getDrawable()).stop();
            tvStatus.setText("下拉刷新");
            smoothScrollTo(0);
            mState = STATE_NORMAL;

        }
        return isOnRefresh;
    }

    /**
     * 下拉刷新完成
     */
    @Override
    public void refreshComplete() {
        Log.d("tag", "refreshComplete");
        mState = STATE_NORMAL;
        ((AnimationDrawable) ivAnim.getDrawable()).stop();
        ivAnim.setImageResource(R.drawable.reading_anim);
        tvStatus.setText("下拉刷新");
        smoothScrollTo(0);

    }

    /**
     * 获取HeaderView
     */
    @Override
    public View getHeaderView() {
        return this;
    }

    private void smoothScrollTo(int destHeight) {
        ValueAnimator animator = ValueAnimator.ofInt(getVisibleHeight(), destHeight);
        animator.setDuration(300);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                setVisibleHeight(value);

            }
        });
        animator.start();
    }

    /**
     * 获取Header的显示高度
     */
    @Override
    public int getVisibleHeight() {
        ViewGroup.LayoutParams layoutParams = rlContainer.getLayoutParams();
        return layoutParams.height;
    }

    public void setVisibleHeight(int height) {
        if (height < 0) height = 0;
        LayoutParams lp = (LayoutParams) rlContainer.getLayoutParams();
        lp.height = height;
        rlContainer.setLayoutParams(lp);
    }
}
