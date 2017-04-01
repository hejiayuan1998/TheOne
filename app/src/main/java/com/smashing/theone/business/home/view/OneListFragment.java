package com.smashing.theone.business.home.view;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.smashing.theone.R;
import com.smashing.theone.bean.Content;
import com.smashing.theone.bean.Weather;
import com.smashing.theone.business.home.adapter.OneListAdapter;
import com.smashing.theone.business.home.contract.OneListContract;
import com.smashing.theone.business.home.model.OneListModelImpl;
import com.smashing.theone.business.home.presenter.OneListPresenterImpl;
import com.smashing.theone.business.main.MainActivity;
import com.smashing.theone.common.base.BaseFragment;
import com.smashing.theone.common.utils.UIUtils;
import com.smashing.theone.common.widget.LoadingLayout;
import com.smashing.theone.common.widget.ReadingRefreshHeader;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * author: chensen
 * date: 2017年03月27日8:20
 * desc: 首页oneList列表
 */

@SuppressLint("ValidFragment")
public class OneListFragment extends BaseFragment<OneListPresenterImpl> implements OneListContract.View {
    @Bind(R.id.loading_layout)
    LoadingLayout loadingLayout;
    @Bind(R.id.rv_one_list)
    LRecyclerView rvOneList;

    View footer;

    TextView tvDate;
    TextView tvWeather;

    OneListAdapter dataAdapter;
    LRecyclerViewAdapter lRecyclerViewAdapter;
    String id;


    @SuppressLint("ValidFragment")
    public OneListFragment(String id) {
        this.id = id;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_one_list;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    protected void initView() {

        //这个方法要在设置adapter前使用 orz...
        rvOneList.setRefreshHeader(new ReadingRefreshHeader(mContext));

        dataAdapter = new OneListAdapter(mContext);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(dataAdapter);
        rvOneList.setAdapter(lRecyclerViewAdapter);

        rvOneList.setLayoutManager(new LinearLayoutManager(mContext));


        View header = LayoutInflater.from(mContext).inflate(R.layout.item_list_header, rvOneList, false);
        lRecyclerViewAdapter.addHeaderView(header);
        footer = LayoutInflater.from(mContext).inflate(R.layout.bottom_recyclerview, rvOneList, false);

        tvDate = (TextView) header.findViewById(R.id.tv_date);
        tvWeather = (TextView) header.findViewById(R.id.tv_weather);


        rvOneList.setLScrollListener(new LRecyclerView.LScrollListener() {
            @Override
            public void onScrollUp() {

            }

            @Override
            public void onScrollDown() {

            }

            @Override
            public void onScrolled(int distanceX, int distanceY) {
                if (distanceY > UIUtils.dip2px(50) && !((HomeFragment) ((MainActivity) getActivity()).getSupportFragmentManager().findFragmentByTag("0")).isTitleBarShowing()) {
                    ((HomeFragment) ((MainActivity) getActivity()).getSupportFragmentManager().findFragmentByTag("0")).showTitleBar();
                } else if (distanceY <= UIUtils.dip2px(50) && ((HomeFragment) ((MainActivity) getActivity()).getSupportFragmentManager().findFragmentByTag("0")).isTitleBarShowing()) {
                    ((HomeFragment) ((MainActivity) getActivity()).getSupportFragmentManager().findFragmentByTag("0")).hideTitleBar();
                }

            }


            @Override
            public void onScrollStateChanged(int state) {

            }
        });


        rvOneList.setLoadMoreEnabled(false);
        rvOneList.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getOneList(id);
            }
        });
        //  rvOneList.forceToRefresh();
        loadingLayout.setStatus(LoadingLayout.Loading);
        mPresenter.getOneList(id);


    }

    @Override
    public void showWeather(Weather weather, String date) {
        tvDate.setText(date.substring(0, 11).replace("-", " / "));
        tvWeather.setText(weather.getClimate() + ", " + weather.getCity_name());
    }

    @Override
    public void showOneList(ArrayList<Content> listData) {
        dataAdapter.setDataList(listData);
        UIUtils.refresh(rvOneList, lRecyclerViewAdapter);

        //如果不是最后一页，就添加bottom
        final HomeFragment homeFragment = (HomeFragment) ((MainActivity) getActivity()).getSupportFragmentManager().findFragmentByTag("0");
        int currentPage = homeFragment.getCurrentPage();

        if (currentPage < homeFragment.idList.size()) {
            lRecyclerViewAdapter.addFooterView(footer);
            lRecyclerViewAdapter.getFooterView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    homeFragment.viewPager.setCurrentItem(homeFragment.getCurrentPage() + 1);

                }
            });
        }

    }


    @Override
    protected OneListPresenterImpl initPresenter() {
        mPresenter = new OneListPresenterImpl(this, new OneListModelImpl());
        return mPresenter;
    }

    @Override
    public void showError() {
        super.showError();
        loadingLayout.setStatus(LoadingLayout.Error);
    }

    @Override
    public void showSuccess() {
        super.showSuccess();
        loadingLayout.setStatus(LoadingLayout.Success);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("tag", "onDestroyViewonDestroyView");
    }
}
