package com.smashing.theone.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import com.smashing.theone.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * author: chensen
 * date: 2017年04月05日16:24
 * desc: 此控件在播放的时候背景和播放按钮会同时旋转（故没有用这个）
 */

public class CDView extends android.support.v7.widget.AppCompatImageView {
    private Paint mPaint;

    private int mWidth;//宽度
    private float mPosRotate;
    private int mDownX;
    private int mDownY;
    private int mCenterXY;
    private int mPlayRadius;


    private Bitmap bitmapPlay;//播放按钮
    private Timer mTimer;//定时器
    private boolean mIsPlaying;//是否处于播放状态


    public CDView(Context context) {
        this(context, null);
    }

    public CDView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CDView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPosRotate = 0;
        bitmapPlay = BitmapFactory.decodeResource(getResources(), R.drawable.play);
        mTimer = new Timer();
        mIsPlaying = false;
        mPlayRadius = bitmapPlay.getWidth() / 2;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        mWidth = Math.min(width, height);
        setMeasuredDimension(mWidth, mWidth);

        mCenterXY = mWidth / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.rotate(-mPosRotate, mWidth / 2, mWidth / 2);
        // drawCD(canvas);//绘制圆形图片
        drawPlay(canvas);//绘制播放按钮

    }

    //绘制圆形图片
    private void drawCD(Canvas canvas) {


    }

    //绘制播放按钮
    private void drawPlay(Canvas canvas) {
        canvas.drawBitmap(bitmapPlay, (mWidth - bitmapPlay.getWidth()) / 2, (mWidth - bitmapPlay.getHeight()) / 2, null);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                mDownX = (int) event.getX();
                mDownY = (int) event.getY();

                //如果没有点在可点击的区域，则不接收事件
                if (mDownX < mCenterXY - mPlayRadius
                        || mDownX > mCenterXY + mPlayRadius
                        || mDownY < mCenterXY - mPlayRadius
                        || mDownY > mCenterXY + mPlayRadius
                        ) {
                    return false;
                }

                break;
            case MotionEvent.ACTION_MOVE:
                //如果移动过，即不是点击事件，不再接收事件
                if (event.getX() != mDownX || event.getY() != mDownY) {
                    return false;
                }
                break;
            case MotionEvent.ACTION_UP:
                //经过上面的排除，此处若能接受到up事件，证明是点击事件
                if (mIsPlaying) {

                } else {
                    play();
                    if (playListener != null) {
                        playListener.onPlay();
                        Log.d("tag", "play");
                    }
                }


                break;

        }
        return true;
    }

    /**
     * 开始播放音乐
     * 使用timer每0.1s叠加0.6°旋转角度
     */
    private void play() {
        mIsPlaying = true;
        if (mTimer == null) {
            mTimer = new Timer();
        }

        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mPosRotate = (mPosRotate + 0.2f) % 360f;

                post(new Runnable() {
                    @Override
                    public void run() {
                        setPivotX(mWidth / 2);
                        setPivotY(mWidth / 2);
                        setRotation(mPosRotate);
                        invalidate();
                    }
                });

            }
        }, 0, 30);

    }

    onPlayListener playListener;

    public interface onPlayListener {
        void onPlay();
    }

    public void setOnPlayListener(onPlayListener playListener) {
        this.playListener = playListener;
    }
}
