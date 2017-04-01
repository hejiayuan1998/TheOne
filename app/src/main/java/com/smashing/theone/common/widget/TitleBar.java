package com.smashing.theone.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smashing.theone.R;
import com.smashing.theone.common.utils.UIUtils;

/**
 * author: chensen
 * date: 2017年03月27日14:53
 * desc:
 */

public class TitleBar extends FrameLayout {
    int leftIconRes;
    int leftIconSize;

    int rightIconRes;
    int rightIconSize;

    int titleSize;
    int titleColor;
    String title;


    RelativeLayout rootView;
    TextView tvTitle;
    TextView tvRight;

    ImageView ivLeft;
    ImageView ivRight;

    onLeftIconClickListener mLeftListener;
    onRightIconClickListener mRightListener;

    public TitleBar(Context context) {
        this(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBar, defStyleAttr, 0);
        int length = typedArray.length();
        if (length > 0) {

            leftIconRes = typedArray.getResourceId(R.styleable.TitleBar_leftIcon, R.drawable.back);
            setLeftIcon(leftIconRes);

            leftIconSize = (int) typedArray.getDimensionPixelSize(R.styleable.TitleBar_leftIconSize, UIUtils.dip2px(40));
            setLeftIconSize(leftIconSize);

            rightIconRes = typedArray.getResourceId(R.styleable.TitleBar_rightIcon, R.drawable.search);
            setRightIcon(rightIconRes);

            rightIconSize = (int) typedArray.getDimensionPixelSize(R.styleable.TitleBar_rightIconSize, UIUtils.dip2px(40));
            setRightIconSize(rightIconSize);

            titleSize = (int) typedArray.getDimensionPixelSize(R.styleable.TitleBar_titleSize, 20);
            setTitleSize(titleSize);
            titleColor = typedArray.getColor(R.styleable.TitleBar_titleColor, getResources().getColor(R.color.tv_main_nav));
            setTitleColor(titleColor);
            title = typedArray.getString(R.styleable.TitleBar_title);
            setTitle(title);

        }

    }


    private void init(Context context) {
        View root = LayoutInflater.from(context).inflate(R.layout.item_title_bar, this, false);
        addView(root);
        rootView = (RelativeLayout) root.findViewById(R.id.rl_root_view);
        tvTitle = (TextView) root.findViewById(R.id.tv_title);
        tvRight = (TextView) root.findViewById(R.id.tv_right);

        ivLeft = (ImageView) root.findViewById(R.id.iv_left);
        ivRight = (ImageView) root.findViewById(R.id.iv_right);


        ivLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLeftListener != null) {
                    mLeftListener.onLeftIconClick(v);
                }

            }
        });
        ivRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRightListener != null) {
                    mRightListener.onRightIconClick(v);
                }

            }
        });


    }


    public interface onLeftIconClickListener {
        void onLeftIconClick(View v);
    }

    public interface onRightIconClickListener {
        void onRightIconClick(View v);
    }


    public void setOnLeftIconClickListener(onLeftIconClickListener listener) {

        this.mLeftListener = listener;
    }

    public void setOnRightIconClickListener(onRightIconClickListener listener) {

        this.mRightListener = listener;
    }


    private void setTitleSize(int titleSize) {
        tvTitle.setTextSize(titleSize);
    }

    private void setTitleColor(int titleColor) {
        tvTitle.setTextColor(titleColor);

    }

    private void setRightIconSize(int rightIconSize) {
        ViewGroup.LayoutParams layoutParams = ivRight.getLayoutParams();
        layoutParams.width = rightIconSize;
        layoutParams.height = rightIconSize;
        ivRight.setLayoutParams(layoutParams);
    }

    private void setLeftIconSize(int leftIconSize) {
        ViewGroup.LayoutParams layoutParams = ivLeft.getLayoutParams();
        layoutParams.width = leftIconSize;
        layoutParams.height = leftIconSize;
        ivLeft.setLayoutParams(layoutParams);
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    public void setRightMsg(String msg) {
        tvRight.setText(msg);
    }

    public void setLeftIcon(int resId) {
        ivLeft.setImageResource(resId);
    }

    public void setRightIcon(int redId) {
        ivRight.setImageResource(redId);
    }


    public void showLeftIcon(boolean show) {
        ivLeft.setVisibility(show ? VISIBLE : GONE);
    }

    public void showRightIcon(boolean show) {
        ivRight.setVisibility(show ? VISIBLE : GONE);
    }

    public void showTitle(boolean show) {
        tvTitle.setVisibility(show ? VISIBLE : GONE);
    }

    public void showRightMsg(boolean show) {
        tvRight.setVisibility(show ? VISIBLE : GONE);
    }


    public void setTitleBarHeight(int height) {
        ViewGroup.LayoutParams params = getLayoutParams();
        params.height = height;
        setLayoutParams(params);
    }

}
