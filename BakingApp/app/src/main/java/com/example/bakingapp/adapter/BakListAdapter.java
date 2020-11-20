package com.example.bakingapp.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bakingapp.R;
import com.example.bakingapp.bean.Baking;

import java.util.List;

public class BakListAdapter extends RecyclerView.Adapter<BakListAdapter.BakViewHolder> {
    Context context;
    List<Baking> list;
    ItemClickListener itemClickListener;

    public BakListAdapter() {
    }

    public BakListAdapter(Context context, List<Baking> list, ItemClickListener itemClickListener) {
        this.context = context;
        this.list = list;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public BakViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BakViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bak_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BakViewHolder holder, final int position) {
        Glide.with(context).load(list.get(position).getImage()).placeholder(R.mipmap.bakloading).centerCrop().into(holder.ivImg);
        holder.tvName.setText(list.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClick(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class BakViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImg;
        TextView tvName;

        public BakViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImg = itemView.findViewById(R.id.iv_show_img);
            tvName = itemView.findViewById(R.id.tv_bak_name);
        }
    }
}
