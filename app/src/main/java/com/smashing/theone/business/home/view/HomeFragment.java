package com.smashing.theone.business.home.view;

import android.animation.ObjectAnimator;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;
import com.smashing.theone.R;
import com.smashing.theone.api.Api;
import com.smashing.theone.business.home.adapter.HomeAdapter;
import com.smashing.theone.business.home.model.IdBean;
import com.smashing.theone.business.home.presenter.OneListPresenterImpl;
import com.smashing.theone.common.base.BaseFragment;
import com.smashing.theone.common.widget.DepthPageTransformer;
import com.smashing.theone.common.widget.TitleBar;

import java.util.ArrayList;

import butterknife.Bind;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author: chensen
 * date: 2017年03月24日17:19
 * desc:
 */

public class HomeFragment extends BaseFragment {
    @Bind(R.id.title_bar)
    TitleBar titleBar;
    @Bind(R.id.view_pager)
    ViewPager viewPager;

    HomeAdapter adapter;
    ArrayList<OneListFragment> listFragments;

    ArrayList<String> idList = new ArrayList<>();
    public boolean isTitleBarShowing = false;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        titleBar.setOnLeftIconClickListener(new TitleBar.onLeftIconClickListener() {

            @Override
            public void onLeftIconClick(View v) {
                Toast.makeText(mContext, "左图标", 0).show();
            }
        });
        titleBar.setOnRightIconClickListener(new TitleBar.onRightIconClickListener() {
            @Override
            public void onRightIconClick(View v) {
                Toast.makeText(mContext, "右图标", 0).show();
            }
        });

        titleBar.showRightIcon(true);


        listFragments = new ArrayList<>();
        getIdList();
    }

    private void getIdList() {
        Subscription subscribe = OkGo.get(Api.ID_LIST)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(String s) {
                        IdBean idBean = new Gson().fromJson(s, IdBean.class);
                        idList = idBean.getData();
                        initViewPager();
                    }
                });
        addSubscribe(subscribe);
    }

    public void initViewPager() {
        for (int i = 0; i < idList.size(); i++) {
            listFragments.add(new OneListFragment(idList.get(i)));
        }

        adapter = new HomeAdapter(getActivity().getSupportFragmentManager(), listFragments);
        viewPager.setAdapter(adapter);

        viewPager.setPageTransformer(true, new DepthPageTransformer());

    }

    @Override
    protected OneListPresenterImpl initPresenter() {
        return null;
    }

    public TitleBar getTitleBar() {
        return titleBar;
    }

    public void hideTitleBar() {
        isTitleBarShowing = false;
        ObjectAnimator.ofFloat(titleBar, "translationY", 0, -titleBar.getHeight())
                .setDuration(400)
                .start();
//        ObjectAnimator.ofFloat(titleBar, "alpha", 1, 0)
//                .setDuration(500)
//                .start();

    }

    public void showTitleBar() {
        isTitleBarShowing = true;
        ObjectAnimator.ofFloat(titleBar, "translationY", -titleBar.getHeight(), 0)
                .setDuration(400)
                .start();
//        ObjectAnimator.ofFloat(titleBar, "alpha", 0, 1)
//                .setDuration(500)
//                .start();
    }

    public boolean isTitleBarShowing() {

        return isTitleBarShowing;
    }

    public int getCurrentPage() {
        return viewPager.getCurrentItem();

    }

}
