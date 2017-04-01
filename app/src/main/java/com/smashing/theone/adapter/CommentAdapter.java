package com.smashing.theone.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smashing.theone.R;
import com.smashing.theone.bean.Comment;
import com.smashing.theone.common.base.BaseAdapter;
import com.smashing.theone.common.utils.ImageLoader;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * author: chensen
 * date: 2017年03月31日9:46
 * desc: 评论列表的适配器
 */

public class CommentAdapter extends BaseAdapter<Comment> {

    public CommentAdapter(Context mContext) {
        super(mContext);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rv_comment, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder viewHolder = (ViewHolder) holder;
        final Comment comment = mDataList.get(position);

        ImageLoader.showImage(mContext, comment.getUser().getWeb_url(), viewHolder.civHeader);

        viewHolder.tvUserName.setText(comment.getUser().getUser_name());
        viewHolder.tvTime.setText(comment.getCreated_at());

        if (comment.getQuote() != null && comment.getTouser() != null) {
            viewHolder.llTouser.setVisibility(View.VISIBLE);
            viewHolder.tvQuote.setText(comment.getQuote());
            viewHolder.tvTouserName.setText(comment.getTouser().getUser_name());
        }

        viewHolder.tvComment.setText(comment.getContent());
        viewHolder.tvPraiseNum.setText(comment.getPraisenum());

        viewHolder.ivComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "评论", 0).show();
            }
        });

        viewHolder.ivPraise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "点赞", 0).show();
            }
        });


        viewHolder.tvComment.post(new Runnable() {
            @Override
            public void run() {
                if (viewHolder.tvComment.getLineCount() > 3) { //获取行数，如果大于3行，显示 展开/收起
                    viewHolder.tvComment.setMaxLines(3);//如果超过3行，则默认显示前3行
                    viewHolder.tvExpand.setVisibility(View.VISIBLE);
                } else {
                    viewHolder.tvExpand.setVisibility(View.GONE);

                }
            }
        });


        viewHolder.tvExpand.setOnClickListener(new View.OnClickListener() {
            boolean isExpand = false;

            @Override
            public void onClick(View v) {
                if (isExpand) {
                    viewHolder.tvExpand.setText("展开");
                    viewHolder.tvComment.setMaxLines(3);//隐藏

                } else {
                    viewHolder.tvExpand.setText("收起");
                    viewHolder.tvComment.setMaxLines(50);//隐藏
                }
                isExpand = !isExpand;


            }
        });


    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.civ_header)
        CircleImageView civHeader;
        @Bind(R.id.tv_user_name)
        TextView tvUserName;
        @Bind(R.id.tv_time)
        TextView tvTime;
        @Bind(R.id.ll_touser)
        LinearLayout llTouser;
        @Bind(R.id.tv_touser_name)
        TextView tvTouserName;
        @Bind(R.id.tv_quote)
        TextView tvQuote;
        @Bind(R.id.tv_comment)
        TextView tvComment;
        @Bind(R.id.tv_expand)
        TextView tvExpand;
        @Bind(R.id.iv_comment)
        ImageView ivComment;
        @Bind(R.id.iv_praise)
        ImageView ivPraise;
        @Bind(R.id.tv_praise_num)
        TextView tvPraiseNum;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
