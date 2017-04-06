package com.smashing.theone.business.movie.view;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.smashing.theone.R;
import com.smashing.theone.bean.Content;
import com.smashing.theone.business.home.adapter.OneListAdapter;
import com.smashing.theone.business.movie.contract.MovieContract;
import com.smashing.theone.business.movie.model.MovieModelImpl;
import com.smashing.theone.business.movie.presenter.MoviePresenterImpl;
import com.smashing.theone.common.base.BaseFragment;
import com.smashing.theone.common.utils.UIUtils;
import com.smashing.theone.common.widget.ReadingRefreshHeader;
import com.smashing.theone.common.widget.TitleBar;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * author: chensen
 * date: 2017年03月25日15:29
 * desc: 影视   由于此页面与阅读页面显示效果一样，所以布局统一用了fragmrnt_read
 */

public class MovieFragment extends BaseFragment<MoviePresenterImpl> implements MovieContract.View {
    @Bind(R.id.title_bar)
    TitleBar titleBar;
    @Bind(R.id.rv_read_list)
    LRecyclerView rvMovieList;

    OneListAdapter dataAdapter;
    LRecyclerViewAdapter lRecyclerViewAdapter;


    @Override
    public int getLayoutId() {
        return R.layout.fragmrnt_read;
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
        titleBar.setTitle(getResources().getString(R.string.the_one_movie));

        rvMovieList.setRefreshHeader(new ReadingRefreshHeader(mContext));
        dataAdapter = new OneListAdapter(mContext);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(dataAdapter);
        rvMovieList.setAdapter(lRecyclerViewAdapter);

        rvMovieList.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));


        lRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
                intent.putExtra("itemId", mPresenter.getItemId(position));
                startActivity(intent);
            }
        });
        rvMovieList.setLoadMoreEnabled(false);
        rvMovieList.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getList();
            }
        });
        mPresenter.getList();

    }

    @Override
    protected MoviePresenterImpl initPresenter() {
        return new MoviePresenterImpl(this, new MovieModelImpl());
    }

    @Override
    public void showList(ArrayList<Content> listData) {
        dataAdapter.setDataList(listData);
        UIUtils.refresh(rvMovieList, lRecyclerViewAdapter);
    }
}
