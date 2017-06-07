package com.cfm880.learnipc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cfm880.learnipc.IPCApplication;
import com.cfm880.learnipc.R;
import com.cfm880.learnipc.datasource.entity.item.News;

import java.util.List;

/**
 * Created by chengfangming on 2017/6/7.
 */

public class NewsRVAdapter extends RecyclerView.Adapter<NewsRVAdapter.NewsViewHolder>{
    private List<News> mList;

    public NewsRVAdapter(List<News> list) {
        mList = list;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        Glide.with(IPCApplication.getInstance()).load(mList.get(position).getNews_image_url()).into(holder.ivNewsIcon);
        holder.tvNewsTitle.setText(mList.get(position).getNews_title());
        holder.tvNewsTime.setText(mList.get(position).getNews_update_time());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivNewsIcon;
        public TextView tvNewsTitle;
        public TextView tvNewsTime;

        public NewsViewHolder(View itemView) {
            super(itemView);
            ivNewsIcon = (ImageView) itemView.findViewById(R.id.iv_news_icon);
            tvNewsTitle = (TextView) itemView.findViewById(R.id.tv_news_title);
            tvNewsTime = (TextView) itemView.findViewById(R.id.tv_news_update_time);
        }
    }
}
