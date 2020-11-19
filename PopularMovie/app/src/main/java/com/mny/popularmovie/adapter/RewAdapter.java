package com.mny.popularmovie.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mny.popularmovie.R;
import com.mny.popularmovie.bean.MoviesReviews;

import java.util.ArrayList;
import java.util.List;

public class RewAdapter extends RecyclerView.Adapter<RewAdapter.MvHolder> {
    List<MoviesReviews.ResultsBean> list = new ArrayList<>();

    @NonNull
    @Override
    public RewAdapter.MvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RewAdapter.MvHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.reviews, parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull RewAdapter.MvHolder holder, int position) {
        holder.tvA.setText(list.get(position).getAuthor());
        holder.tvV.setText(list.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MvHolder extends RecyclerView.ViewHolder {
        TextView tvA;
        TextView tvV;

        public MvHolder(@NonNull View itemView) {
            super(itemView);
            tvA = itemView.findViewById(R.id.tv_author);
            tvV = itemView.findViewById(R.id.tv_content);

        }
    }

    public void addData(List<MoviesReviews.ResultsBean> list) {
        this.list.clear();
        this.list.addAll(list);
        this.notifyDataSetChanged();
    }
}
