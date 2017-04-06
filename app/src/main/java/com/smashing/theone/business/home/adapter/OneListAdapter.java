package com.smashing.theone.business.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smashing.theone.R;
import com.smashing.theone.app.AppConstant;
import com.smashing.theone.bean.Content;
import com.smashing.theone.business.common.PicActivity;
import com.smashing.theone.business.movie.view.MovieDetailActivity;
import com.smashing.theone.business.music.view.MusicDetailActivity;
import com.smashing.theone.business.read.view.QuestionDetilActivity;
import com.smashing.theone.business.read.view.ReadDetailActivity;
import com.smashing.theone.common.base.BaseAdapter;
import com.smashing.theone.common.utils.ImageLoader;
import com.smashing.theone.common.widget.CDLayout;
import com.smashing.theone.common.widget.CDView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit.http.POST;

/**
 * author: chensen
 * date: 2017年03月26日11:10
 * desc:首页 一个列表 的适配器
 */

/**
 * category字段表示类别（自己根据返回的json推断的）:
 * 0:摄影  插画
 * 1：阅读  漫画 one实验室 一周语文 onstory
 * 2：连载
 * 3：问答
 * 4：音乐  深夜电台
 * 5：影视 视频
 * <p>
 * 0和4单独拿出来，用不同的item
 * 其他的用通用的item
 */

public class OneListAdapter extends BaseAdapter<Content> {

    private int playPosition = -1;//记录正在播放的位置，否则的话会因为item的复用问题导致状态的混乱。目前没有找到更好的解决办法


    public OneListAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder;
        switch (viewType) {
            case 0://摄影 绘画
                view = LayoutInflater.from(mContext).inflate(R.layout.item_list_photo, parent, false);
                holder = new PhotoVeiwHolder(view);
                break;
            case 4://音乐 深夜电台
                view = LayoutInflater.from(mContext).inflate(R.layout.item_list_music, parent, false);
                holder = new MusicViewHolder(view);
                break;
            default:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_list_common, parent, false);
                holder = new CommonViewHolder(view);
                break;
        }


        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Content content = mDataList.get(position);
        switch (mDataList.get(position).getCategory()) {
            case "0"://摄影 绘画
                PhotoVeiwHolder photoVeiwHolder = (PhotoVeiwHolder) holder;
                setPhotoData(photoVeiwHolder, position, content);
                break;
            case "4": //音乐
                MusicViewHolder musicViewHolder = (MusicViewHolder) holder;
                setMusicData(musicViewHolder, position, content);
                break;
            default:
                CommonViewHolder commonViewHolder = (CommonViewHolder) holder;
                setCommonData(commonViewHolder, position, content);
                break;
        }


    }

    private void setPhotoData(PhotoVeiwHolder photoVeiwHolder, final int position, final Content content) {

        ImageLoader.showImage(mContext, content.getImg_url(), photoVeiwHolder.ivPic);
        photoVeiwHolder.tvTitle.setText("- " + content.getTitle() + " -");
        photoVeiwHolder.tvPicInfo.setText(content.getPic_info());
        photoVeiwHolder.tvForward.setText(content.getForward());
        photoVeiwHolder.tvWordsInfo.setText(content.getWords_info());
        photoVeiwHolder.tvLikeCount.setText(content.getLike_count());

        photoVeiwHolder.ivLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "喜欢了 " + position, 0).show();
            }
        });

        photoVeiwHolder.ivShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "分享了 " + position, 0).show();
            }
        });

        photoVeiwHolder.ivPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PicActivity.class);
                intent.putExtra("url", content.getImg_url());
                mContext.startActivity(intent);
            }
        });
    }

    private void setMusicData(final MusicViewHolder musicViewHolder, final int position, final Content content) {

        //4
        musicViewHolder.tvCategory.setText("- 音乐 -");
        musicViewHolder.tvTitle.setText(content.getTitle());
        musicViewHolder.tvUserName.setText("文 / " + content.getAuthor().getUser_name());
        ImageLoader.showCircleImage(mContext, content.getImg_url(), musicViewHolder.cdLayout.getIvPic());

        musicViewHolder.tvDesc.setText(content.getSubtitle() + " · " + content.getAudio_author() + " | " + content.getAudio_album());
        musicViewHolder.tvForward.setText(content.getForward());
        musicViewHolder.tvLastUpdateTime.setText(content.getLast_update_date());
        musicViewHolder.tvLikeCount.setText(content.getLike_count());

        musicViewHolder.ivLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "喜欢了 " + position, 0).show();
            }
        });

        musicViewHolder.ivShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "分享了 " + position, 0).show();
            }
        });
        musicViewHolder.llRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MusicDetailActivity.class);
                intent.putExtra("itemId", content.getItem_id());
                mContext.startActivity(intent);
            }
        });

        if (playPosition != position) {
            musicViewHolder.cdLayout.reSet();
        } else {
            Log.d("tag", "继续播放");
            musicViewHolder.cdLayout.continuePlay();
        }


        musicViewHolder.cdLayout.setOnPlayListener(new CDLayout.onPlayListener() {
            @Override
            public void onPlay() {
                playPosition = position;


            }
        });
        musicViewHolder.cdLayout.setStopListener(new CDLayout.onStopListener() {

            @Override
            public void onStop() {
                playPosition = -1;
            }
        });

    }

    private void setCommonData(CommonViewHolder commonViewHolder, final int position, final Content content) {

        if (content.getCategory().equals("2")) {                    //连载
            commonViewHolder.tvCategory.setText("- 连载 -");
        } else if (content.getCategory().equals("3")) {                //问答
            commonViewHolder.tvCategory.setText("- 问答 -");
        } else if (content.getCategory().equals("5")) {                //影视
            commonViewHolder.tvCategory.setText("- 影视 -");
        } else if (content.getTag_list() != null && content.getTag_list().size() > 0) {  //此处categary为1
            commonViewHolder.tvCategory.setText("- " + content.getTag_list().get(0).getTitle() + " -");
        } else {
            commonViewHolder.tvCategory.setText("- 阅读 -");
        }
        commonViewHolder.tvTitle.setText(content.getTitle());
        commonViewHolder.tvUserName.setText("文 / " + content.getAuthor().getUser_name());
        ImageLoader.showImage(mContext, content.getImg_url(), commonViewHolder.ivPic);
        commonViewHolder.tvForward.setText(content.getForward());
        commonViewHolder.tvLastUpdateTime.setText(content.getLast_update_date());
        commonViewHolder.tvLikeCount.setText(content.getLike_count());

        commonViewHolder.ivLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "喜欢了 " + position, 0).show();
            }
        });

        commonViewHolder.ivShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "分享了 " + position, 0).show();
            }
        });
        commonViewHolder.tvCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "tvCategory " + position, 0).show();
            }
        });

        if (content.getCategory().equals("3")) {                //问答
            commonViewHolder.llRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, QuestionDetilActivity.class);
                    intent.putExtra("itemId", content.getItem_id());
                    mContext.startActivity(intent);
                }
            });
        } else if (content.getCategory().equals("5")) {                //影视
            commonViewHolder.llRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, MovieDetailActivity.class);
                    intent.putExtra("itemId", content.getItem_id());
                    mContext.startActivity(intent);
                }
            });
        } else {
            commonViewHolder.llRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ReadDetailActivity.class);
                    intent.putExtra("itemId", content.getItem_id());
                    mContext.startActivity(intent);
                }
            });
        }


    }


    @Override
    public int getItemViewType(int position) {
        return Integer.parseInt(mDataList.get(position).getCategory());
    }

    //第一个条目， 绘画或者摄影
    class PhotoVeiwHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_pic)
        ImageView ivPic;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_pic_info)
        TextView tvPicInfo;
        @Bind(R.id.tv_forward)
        TextView tvForward;
        @Bind(R.id.tv_words_info)
        TextView tvWordsInfo;
        @Bind(R.id.tv_like_count)
        TextView tvLikeCount;
        @Bind(R.id.iv_like)
        ImageView ivLike;
        @Bind(R.id.iv_share)
        ImageView ivShare;

        public PhotoVeiwHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    //音乐
    class MusicViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.ll_root)
        LinearLayout llRoot;
        @Bind(R.id.rl_music)
        RelativeLayout rlMusic;
        @Bind(R.id.tv_category)
        TextView tvCategory;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_user_name)
        TextView tvUserName;
        @Bind(R.id.cd_layout)
        CDLayout cdLayout;
        @Bind(R.id.tv_desc)
        TextView tvDesc;
        @Bind(R.id.tv_forward)
        TextView tvForward;
        @Bind(R.id.tv_last_update_time)
        TextView tvLastUpdateTime;
        @Bind(R.id.tv_like_count)
        TextView tvLikeCount;
        @Bind(R.id.iv_like)
        ImageView ivLike;
        @Bind(R.id.iv_share)
        ImageView ivShare;

        public MusicViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    //通用 包括 阅读，影视，连载，漫画等
    class CommonViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.ll_root)
        LinearLayout llRoot;
        @Bind(R.id.tv_category)
        TextView tvCategory;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_user_name)
        TextView tvUserName;
        @Bind(R.id.iv_pic)
        ImageView ivPic;
        @Bind(R.id.tv_forward)
        TextView tvForward;
        @Bind(R.id.tv_last_update_time)
        TextView tvLastUpdateTime;
        @Bind(R.id.tv_like_count)
        TextView tvLikeCount;
        @Bind(R.id.iv_like)
        ImageView ivLike;
        @Bind(R.id.iv_share)
        ImageView ivShare;

        public CommonViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
