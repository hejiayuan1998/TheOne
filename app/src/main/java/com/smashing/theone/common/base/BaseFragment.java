package com.smashing.theone.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * author: chensen
 * date: 2017年03月23日9:28
 * desc:
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {
    protected String TAG;
    protected Context mContext;
    protected View mRootView;

    protected T mPresenter;
    protected CompositeSubscription compositeSubscription;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getClass().getSimpleName();
        mContext = (BaseActivity) getActivity();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, mRootView);
        mPresenter = initPresenter();
        initView();

        return mRootView;
    }


    public abstract int getLayoutId();

    protected abstract void initView();

    protected abstract T initPresenter();


    /**
     * 用于解除订阅
     *
     * @param subscription
     */
    public void addSubscribe(Subscription subscription) {
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
        }
        compositeSubscription.add(subscription);
    }

    public void unSubscribe() {
        if (compositeSubscription != null)
            compositeSubscription.clear();
    }


    public void showLoading() {
        //LoadingDialog.showLoadingDialog(getActivity());


    }

    public void showLoading(String msg) {
        // LoadingDialog.showLoadingDialog(getActivity(), msg, false);
    }

    public void hideLoading() {
        //  LoadingDialog.cancleDialog();

    }

    public void showEmpty() {

    }

    public void showError() {

    }
    public  void showSuccess(){

    }

    protected void showShortToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    protected void showLongToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
    }

    protected void showLog(String msg) {
        Log.d(TAG, msg);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.onDestory();
        }
        unSubscribe();
        ButterKnife.unbind(this);
    }
}
