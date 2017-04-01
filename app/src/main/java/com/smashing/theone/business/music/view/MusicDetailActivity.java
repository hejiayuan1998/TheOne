package com.smashing.theone.business.music.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smashing.theone.R;
import com.smashing.theone.adapter.CommentAdapter;
import com.smashing.theone.bean.Comment;
import com.smashing.theone.bean.CommentBean;
import com.smashing.theone.business.music.contract.MusicDetailContract;
import com.smashing.theone.business.music.model.MusicDetailBean;
import com.smashing.theone.business.music.model.MusicDetailModelImpl;
import com.smashing.theone.business.music.presenter.MusicDetailPresenterImpl;
import com.smashing.theone.common.base.BaseActivity;
import com.smashing.theone.common.utils.Htmlutils;
import com.smashing.theone.common.utils.ImageLoader;
import com.smashing.theone.common.widget.LoadingLayout;
import com.smashing.theone.common.widget.TitleBar;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * author: chensen
 * date: 2017年03月30日16:47
 * desc:
 */

public class MusicDetailActivity extends BaseActivity<MusicDetailPresenterImpl> implements MusicDetailContract.View {

    @Bind(R.id.tiitle_bar)
    TitleBar tiitleBar;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_album)
    TextView tvAlbum;
    @Bind(R.id.tv_story_name)
    TextView tvStoryName;
    @Bind(R.id.tv_story_author)
    TextView tvStoryAuthor;
    @Bind(R.id.web_content)
    WebView webContent;
    @Bind(R.id.tv_editor)
    TextView tvEditor;
    @Bind(R.id.tv_resource)
    TextView tvResource;
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
    @Bind(R.id.loading_layout)
    LoadingLayout loadingLayout;
    @Bind(R.id.iv_start)
    ImageView ivStart;
    @Bind(R.id.iv_like)
    ImageView ivLike;
    @Bind(R.id.iv_comment)
    ImageView ivComment;
    @Bind(R.id.tv_like_and_comment)
    TextView tvLikeAndComment;
    @Bind(R.id.civ_cover)
    CircleImageView civCover;

    CommentAdapter commentAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_music_detail;
    }

    @Override
    protected void initView() {
        tiitleBar.setTitle("一个音乐");
        tiitleBar.setOnLeftIconClickListener(new TitleBar.onLeftIconClickListener() {
            @Override
            public void onLeftIconClick(View v) {
                finish();
            }
        });
        tiitleBar.setOnRightIconClickListener(new TitleBar.onRightIconClickListener() {
            @Override
            public void onRightIconClick(View v) {
                Toast.makeText(mContext, "分享", 0).show();
            }
        });


        loadingLayout.setStatus(LoadingLayout.Loading);
        String itemId = getIntent().getStringExtra("itemId");
        mPresenter.getContent(itemId);
        mPresenter.getComment(itemId);

    }

    @Override
    public void showContent(MusicDetailBean.MusicDetailData data) {
        ImageLoader.showImage(mContext, data.getCover(), civCover, R.drawable.default_indi_bg);

        tvName.setText(data.getTitle());
        tvAlbum.setText(data.getAuthor().getUser_name() + " | " + data.getAlbum());

        tvStoryName.setText(data.getStory_title());
        tvStoryAuthor.setText("文 / " + data.getStory_author().getUser_name());

        webContent.loadData(Htmlutils.format(data.getStory()), "text/html;charset=UTF-8", null);

        tvEditor.setText(data.getCharge_edt());
        tvResource.setText(data.getCopyright());

        tVAuthorName.setText(data.getStory_author().getUser_name());
        tVAuthorDesc.setText(data.getStory_author().getDesc());
        ImageLoader.showImage(mContext, data.getStory_author().getWeb_url(), ivAuthorHeader, R.drawable.individual_center);

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
    protected MusicDetailPresenterImpl initPresenter() {
        return new MusicDetailPresenterImpl(this, new MusicDetailModelImpl());
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
                Toast.makeText(mContext, "share", 0).show();
                break;
            case R.id.tv_concern:
                Toast.makeText(mContext, "关注", 0).show();
                break;
        }
    }


}
