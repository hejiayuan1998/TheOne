package com.smashing.theone.business.read.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.smashing.theone.R;
import com.smashing.theone.adapter.CommentAdapter;
import com.smashing.theone.bean.Comment;
import com.smashing.theone.business.read.contract.ReadDetailContract;
import com.smashing.theone.business.read.model.ReadDetailBean;
import com.smashing.theone.business.read.model.ReadDetailModelImpl;
import com.smashing.theone.business.read.presenter.ReadDetailPresenterImpl;
import com.smashing.theone.common.base.BaseActivity;
import com.smashing.theone.common.utils.Htmlutils;
import com.smashing.theone.common.utils.ImageLoader;
import com.smashing.theone.common.widget.LoadingLayout;
import com.smashing.theone.common.widget.TitleBar;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * author: chensen
 * date: 2017年03月30日8:29
 * desc: 文章相关的详情页
 */

public class ReadDetailActivity extends BaseActivity<ReadDetailPresenterImpl> implements ReadDetailContract.View {
    @Bind(R.id.loading_layout)
    LoadingLayout loadingLayout;
    @Bind(R.id.title_bar)
    TitleBar titleBar;
    @Bind(R.id.tv_article_name)
    TextView tvArticleName;
    @Bind(R.id.tv_author)
    TextView tvAuthor;
    @Bind(R.id.wb_content)
    WebView wbContent;
    @Bind(R.id.scrollView)
    ScrollView scrollView;
    @Bind(R.id.tv_editor)
    TextView tvEditor;
    @Bind(R.id.tv_resource)
    TextView tvResource;
    @Bind(R.id.iv_start)
    ImageView ivStart;
    @Bind(R.id.iv_like)
    ImageView ivLike;
    @Bind(R.id.iv_comment)
    ImageView ivComment;
    @Bind(R.id.tv_like_and_comment)
    TextView tvLikeAndComment;
    @Bind(R.id.iv_author_header)
    CircleImageView ivAuthorHeader;
    @Bind(R.id.tV_author_name)
    TextView tVAuthorName;
    @Bind(R.id.tV_author_desc)
    TextView tVAuthorDesc;
    @Bind(R.id.tv_concern)
    TextView tvConcern;
    @Bind(R.id.rv_comment)
    RecyclerView rvComment;

    CommentAdapter commentAdapter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_read_detail;
    }

    @Override
    protected void initView() {

        titleBar.setOnLeftIconClickListener(new TitleBar.onLeftIconClickListener() {
            @Override
            public void onLeftIconClick(View v) {
                finish();
            }
        });
        titleBar.setOnRightIconClickListener(new TitleBar.onRightIconClickListener() {
            @Override
            public void onRightIconClick(View v) {
                Toast.makeText(mContext, "分享", 0).show();
            }
        });

        String itemId = getIntent().getStringExtra("itemId");
        mPresenter.getDetail(itemId);
        mPresenter.getComment(itemId);
    }


    @Override
    public void showContent(ReadDetailBean bean) {


        ReadDetailBean.DataBean data = bean.getData();

        if (data.getTag_list() != null && data.getTag_list().size() > 0) {
            titleBar.setTitle(data.getTag_list().get(0).getTitle());
        } else {
            titleBar.setTitle("一个阅读");
        }

        tvArticleName.setText(data.getHp_title());
        tvAuthor.setText("文 / " + data.getAuthor().get(0).getUser_name());

        wbContent.loadData(Htmlutils.format(data.getHp_content()), "text/html;charset=UTF-8", null);

        tvEditor.setText(data.getHp_author_introduce());
        tvResource.setText(data.getCopyright());

        tVAuthorName.setText(data.getAuthor().get(0).getUser_name());
        tVAuthorDesc.setText(data.getAuthor().get(0).getDesc());
        ImageLoader.showImage(mContext, data.getAuthor().get(0).getWeb_url(), ivAuthorHeader,R.drawable.individual_center);

        tvLikeAndComment.setText(data.getPraisenum() + " 喜欢 · " + data.getCommentnum() + " 评论");

        loadingLayout.setStatus(LoadingLayout.Success);
    }

    @Override
    public void showComment(ArrayList<Comment> listConment) {
        commentAdapter = new CommentAdapter(mContext);
        commentAdapter.addAll(listConment);

        rvComment.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        rvComment.setAdapter(commentAdapter);
    }

    @Override
    protected ReadDetailPresenterImpl initPresenter() {
        return new ReadDetailPresenterImpl(this, new ReadDetailModelImpl());
    }


    @OnClick({R.id.iv_start, R.id.iv_like, R.id.iv_comment, R.id.tv_concern})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_start:
                Toast.makeText(mContext, "star", 0).show();
                break;
            case R.id.iv_like:
                Toast.makeText(mContext, "like", 0).show();
                break;
            case R.id.iv_comment:
                Toast.makeText(mContext, "comment", 0).show();
                break;
            case R.id.tv_concern:
                Toast.makeText(mContext, "concern", 0).show();
                break;
        }
    }


    @Override
    public void showError() {
        super.showError();
        loadingLayout.setStatus(LoadingLayout.Error);
    }

    @Override
    public void showLoading() {
        super.showLoading();
        loadingLayout.setStatus(LoadingLayout.Loading);
    }

    @Override
    public void showEmpty() {
        super.showEmpty();
        loadingLayout.setStatus(LoadingLayout.Empty);
    }
}
