package com.mny.popularmovie.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mny.popularmovie.Config;
import com.mny.popularmovie.R;
import com.mny.popularmovie.bean.MoviesViedo;
import com.mny.popularmovie.interfac.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MvHolder> {
    List<MoviesViedo.ResultsBean> list = new ArrayList<>();

    @NonNull
    @Override
    public VideoAdapter.MvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoAdapter.MvHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.trailer, parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.MvHolder holder, final int position) {
        holder.tvName.setText(list.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != clickListener) {
                    clickListener.onClick(Config.getPlayVideo(list.get(position).getKey()));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MvHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        public MvHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_i_name);
        }
    }

    public void addData(List<MoviesViedo.ResultsBean> list) {
        this.list.clear();
        this.list.addAll(list);
        this.notifyDataSetChanged();
    }

    ItemClickListener clickListener;

    public void setOnClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
