package com.smashing.theone.business.movie.view;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.smashing.theone.R;
import com.smashing.theone.adapter.CommentAdapter;
import com.smashing.theone.bean.Comment;
import com.smashing.theone.business.common.PicActivity;
import com.smashing.theone.business.common.VideoActivity;
import com.smashing.theone.business.movie.adapter.MoviePicAdapter;
import com.smashing.theone.business.movie.contract.MovieDetailContract;
import com.smashing.theone.business.movie.model.MovieDetailBean;
import com.smashing.theone.business.movie.model.MovieDetailModelImpl;
import com.smashing.theone.business.movie.model.MoviePicBean;
import com.smashing.theone.business.movie.presenter.MovieDetailPresenterImpl;
import com.smashing.theone.common.base.BaseActivity;
import com.smashing.theone.common.utils.ImageLoader;
import com.smashing.theone.common.widget.LoadingLayout;
import com.smashing.theone.common.widget.TitleBar;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * author: chensen
 * date: 2017年03月31日18:35
 * desc:
 */

public class MovieDetailActivity extends BaseActivity<MovieDetailPresenterImpl> implements MovieDetailContract.View {
    @Bind(R.id.title_bar)
    TitleBar titleBar;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.tv_page_indicator)
    TextView tvPageIndicator;
    @Bind(R.id.tv_movie_name)
    TextView tvMovieName;
    @Bind(R.id.tv_article_title)
    TextView tvArticleTitle;
    @Bind(R.id.tv_author)
    TextView tvAuthor;
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
    @Bind(R.id.ll_comment)
    LinearLayout llComment;
    @Bind(R.id.loading_layout)
    LoadingLayout loadingLayout;

    MoviePicAdapter moviePicAdapter;
    CommentAdapter commentAdapter;


    @Override
    public int getLayoutId() {
        return R.layout.activity_movie_detail;
    }

    @Override
    protected void initView() {
        titleBar.setTitle(getResources().getString(R.string.the_one_movie));
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
        mPresenter.getPic(itemId);
        mPresenter.getContent(itemId);
        mPresenter.getComment(itemId);
    }

    @Override
    protected MovieDetailPresenterImpl initPresenter() {
        return new MovieDetailPresenterImpl(this, new MovieDetailModelImpl());
    }

    @Override
    public void showPic(final MoviePicBean.PicData data) {
        tvMovieName.setText("· 《" + data.getTitle() + "》 ·");

        //视频不为空或者是图片不为空
        if ((data.getVideo() != null && !data.getVideo().equals("")) || (data.getPhoto() != null && data.getPhoto().size() > 0)) {
            final ArrayList<View> views = new ArrayList<>();

            //添加视频
            if (data.getVideo() != null && !data.getVideo().equals("")) {

                RelativeLayout relativeLayout = new RelativeLayout(mContext);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                relativeLayout.setLayoutParams(params);


                //封面图片
                ImageView imageView = new ImageView(mContext);
                imageView.setLayoutParams(params);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ImageLoader.showImage(mContext, data.getDetailcover(), imageView);
                relativeLayout.addView(imageView);

                //播放按钮
                ImageView play = new ImageView(mContext);
                play.setImageResource(R.drawable.play);
                relativeLayout.addView(play);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) play.getLayoutParams();
                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);


                play.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, VideoActivity.class);
                        intent.putExtra("url", data.getVideo());
                        startActivity(intent);
                    }
                });

                views.add(relativeLayout);
            }

            // 添加图片
            for (int i = 0; i < data.getPhoto().size(); i++) {
                ImageView imageView = new ImageView(mContext);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                imageView.setLayoutParams(params);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);

                ImageLoader.showImage(mContext, data.getPhoto().get(i), imageView);
                views.add(imageView);

                final String url = data.getPhoto().get(i);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, PicActivity.class);
                        intent.putExtra("url", url);
                        startActivity(intent);
                    }
                });
            }

            moviePicAdapter = new MoviePicAdapter(views);
            viewPager.setAdapter(moviePicAdapter);

            tvPageIndicator.setText("1 / " + views.size());

            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    tvPageIndicator.setText((position + 1) + " / " + views.size());
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

        }

    }

    @Override
    public void showContent(MovieDetailBean.DataBean.Data data) {

        tvArticleTitle.setText(data.getTitle());
        wbContent.loadData(data.getContent(), "text/html;charset=UTF-8", null);

        tvEditor.setText(data.getCharge_edt());
        tvResource.setText(data.getCopyright());
        tvAuthor.setText("文 / " + data.getUser().getUser_name());

        loadingLayout.setStatus(LoadingLayout.Success);
    }


    @Override
    public void showComment(ArrayList<Comment> listConment) {
        if (listConment != null && listConment.size() > 0) {

            commentAdapter = new CommentAdapter(mContext);
            commentAdapter.addAll(listConment);

            rvComment.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            });
            rvComment.setAdapter(commentAdapter);
        } else {
            llComment.setVisibility(View.GONE);

        }
    }


    @OnClick({R.id.iv_start, R.id.iv_like, R.id.iv_comment})
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
        }
    }
}
