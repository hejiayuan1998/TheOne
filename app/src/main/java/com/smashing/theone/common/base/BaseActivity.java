package com.smashing.theone.common.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.smashing.theone.business.main.MainActivity;

import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**
 * author: chensen
 * date: 2017年03月23日8:43
 * desc:
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    public String TAG;
    protected Context mContext;
    protected T mPresenter;
    private CompositeSubscription compositeSubscription;

    private boolean doubleBackExit = false;
    private boolean doubleBackExitPressedOnce = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TAG = getClass().getSimpleName();
        doBeforeSetContentView();
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mContext = this;
        //创建Presenter
        mPresenter = initPresenter();
        // mPresenter.onAttach(this);
        initView();
    }


    //设置layout前配置
    private void doBeforeSetContentView() {
    }

    //获取布局文件
    public abstract int getLayoutId();

    //初始化view
    protected abstract void initView();

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    protected abstract T initPresenter();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestory();
        }
        unSubscribe();
        ButterKnife.unbind(this);
    }


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

    }

    public void hideLoading() {

    }

    public void showEmpty() {

    }

    public void showError() {

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


    /**
     * 双击退出
     *
     * @param doubleBackExit
     */
    public void setDoubleBackExit(boolean doubleBackExit) {
        this.doubleBackExit = doubleBackExit;
    }


    @Override
    public void onBackPressed() {
        // 非双击退出状态，使用原back逻辑
        if (!doubleBackExit) {
            super.onBackPressed();
            return;
        }
        // 双击返回键关闭程序
        // 如果两秒重置时间内再次点击返回,则退出程序
        if (doubleBackExitPressedOnce) {
            exit();
            return;
        }
        doubleBackExitPressedOnce = true;
        showShortToast("再按一次退出程序");
        Observable.just(null)
                .delay(2000, TimeUnit.SECONDS)
                .subscribe(new Action1<Object>() {

                    @Override
                    public void call(Object o) {
                        // 延迟两秒后重置标志位为false
                        doubleBackExitPressedOnce = false;
                    }
                });


    }

    /**
     * 退出程序
     */
    private void exit() {
        // 退出程序方法有多种 这里使用SingleTask式
        //1、设置MainActivity的加载模式为singleTask
        //2、重写MainActivity中的onNewIntent方法
        //3、需要退出时在Intent中添加退出的tag

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("exit", true);
        startActivity(intent);

    }


}
