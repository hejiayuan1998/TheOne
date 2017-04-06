package com.smashing.theone.business.read.view;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.smashing.theone.R;
import com.smashing.theone.business.read.contract.QuestionContract;
import com.smashing.theone.business.read.model.QuestionBean;
import com.smashing.theone.business.read.model.QuestionModelImpl;
import com.smashing.theone.business.read.presenter.QuestionPresenterImpl;
import com.smashing.theone.common.base.BaseActivity;
import com.smashing.theone.common.utils.Htmlutils;
import com.smashing.theone.common.widget.LoadingLayout;
import com.smashing.theone.common.widget.TitleBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author: chensen
 * date: 2017年04月01日11:33
 * desc: 问答详情页 (没有写评论列表)
 */

public class QuestionDetilActivity extends BaseActivity<QuestionPresenterImpl> implements QuestionContract.View {
    @Bind(R.id.title_bar)
    TitleBar titleBar;
    @Bind(R.id.tv_question)
    TextView tvQuestion;
    @Bind(R.id.tv_question_content)
    TextView tvQuestionContent;
    @Bind(R.id.tv_question_name)
    TextView tvQuestionName;
    @Bind(R.id.tv_answer_name)
    TextView tvAnswerName;
    @Bind(R.id.wb_content)
    WebView wbContent;
    @Bind(R.id.tv_editor)
    TextView tvEditor;
    @Bind(R.id.tv_resource)
    TextView tvResource;
    @Bind(R.id.rv_comment)
    RecyclerView rvComment;
    @Bind(R.id.scrollView)
    ScrollView scrollView;
    @Bind(R.id.iv_start)
    ImageView ivStart;
    @Bind(R.id.iv_like)
    ImageView ivLike;
    @Bind(R.id.iv_comment)
    ImageView ivComment;
    @Bind(R.id.tv_like_and_comment)
    TextView tvLikeAndComment;
    @Bind(R.id.loading_layout)
    LoadingLayout loadingLayout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_question_detail;
    }

    @Override
    protected void initView() {
        titleBar.setTitle(getString(R.string.the_one_question));
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

        loadingLayout.setStatus(LoadingLayout.Loading);
        String itemId = getIntent().getStringExtra("itemId");
        mPresenter.getContent(itemId);

    }

    @Override
    public void showContent(QuestionBean.QusetionBeanData data) {
        tvQuestion.setText(data.getQuestion_title());
        tvQuestionContent.setText(data.getQuestion_content());
        tvQuestionName.setText("——— " + data.getAsker().getUser_name() + "问到");


        tvAnswerName.setText(data.getAnswerer().getUser_name() + "答:");
        wbContent.loadData(Htmlutils.format(data.getAnswer_content()), "text/html;charset=UTF-8", null);

        tvEditor.setText(data.getCharge_edt());
        tvResource.setText(data.getCopyright());

        tvLikeAndComment.setText(data.getPraisenum() + " 喜欢 · " + data.getCommentnum() + " 评论");
        loadingLayout.setStatus(LoadingLayout.Success);


    }

    @Override
    protected QuestionPresenterImpl initPresenter() {
        return new QuestionPresenterImpl(this, new QuestionModelImpl());
    }

    @Override
    public void showLoading() {
        super.showLoading();
    }

    @Override
    public void showError() {
        super.showError();

    }


    @OnClick({R.id.iv_start, R.id.iv_like, R.id.iv_comment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_start:
                break;
            case R.id.iv_like:
                break;
            case R.id.iv_comment:
                break;
        }
    }
}
