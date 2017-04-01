package com.smashing.theone.business.read.view;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.smashing.theone.R;
import com.smashing.theone.bean.Content;
import com.smashing.theone.business.home.adapter.OneListAdapter;
import com.smashing.theone.business.main.MainActivity;
import com.smashing.theone.business.read.contract.ReadContract;
import com.smashing.theone.business.read.model.ReadModelImpl;
import com.smashing.theone.business.read.presenter.ReadPresenterImpl;
import com.smashing.theone.common.base.BaseFragment;
import com.smashing.theone.common.utils.UIUtils;
import com.smashing.theone.common.widget.LoadingLayout;
import com.smashing.theone.common.widget.ReadingRefreshHeader;
import com.smashing.theone.common.widget.TitleBar;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * author: chensen
 * date: 2017年03月28日9:40
 * desc:
 */

public class ReadFragment extends BaseFragment<ReadPresenterImpl> implements ReadContract.View {
    @Bind(R.id.title_bar)
    TitleBar titleBar;

    @Bind(R.id.rv_read_list)
    LRecyclerView rvReadList;

    OneListAdapter dataAdapter;
    LRecyclerViewAdapter lRecyclerViewAdapter;


    @Override
    public void showList(ArrayList<Content> listData) {
        dataAdapter.setDataList(listData);
        UIUtils.refresh(rvReadList, lRecyclerViewAdapter);

    }

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
        titleBar .setTitle("一个阅读");

        rvReadList.setRefreshHeader(new ReadingRefreshHeader(mContext));

        dataAdapter = new OneListAdapter(mContext);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(dataAdapter);
        rvReadList.setAdapter(lRecyclerViewAdapter);

        rvReadList.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));



        lRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String itemId = mPresenter.getItemId(position);
                Intent intent = new Intent(getActivity(), ReadDetailActivity.class);
                intent.putExtra("itemId", itemId);
                Log.d("tag","itemId--"+itemId);
                Log.d("tag","position--"+position);
                startActivity(intent);
            }
        });

        rvReadList.setLoadMoreEnabled(false);
        rvReadList.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getList();
            }
        });
        mPresenter.getList();
    }

    @Override
    protected ReadPresenterImpl initPresenter() {
        return new ReadPresenterImpl(this, new ReadModelImpl());
    }

}
