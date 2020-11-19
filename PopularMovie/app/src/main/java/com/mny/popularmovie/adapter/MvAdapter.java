package com.mny.popularmovie.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mny.popularmovie.Config;
import com.mny.popularmovie.R;
import com.mny.popularmovie.bean.Movies;
import com.mny.popularmovie.interfac.RlvItemClickListener;
import com.mny.popularmovie.utls.DeviceUtils;

import java.util.List;

public class MvAdapter extends RecyclerView.Adapter<MvAdapter.MvHolder> {
    private List<Movies> list;
    private Activity context;
    private RlvItemClickListener listener;
    private int itemWidth;
    private int itemHeight;

    public MvAdapter(List<Movies> list, Activity context, RlvItemClickListener listener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
        itemWidth = DeviceUtils.getScreenWidth(context)/2;
        float f = 185f / 278f;
        itemHeight = (int) (itemWidth / f);
    }

    @NonNull
    @Override
    public MvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MvHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull MvHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClickListener(list.get(position));
            }
        });
        Glide.with(context).load(Config.BASE_IMG + list.get(position).getPoster_path())
//        Glide.with(context).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603604376559&di=555e14d1791741d16c90f17311b28edd&imgtype=0&src=http%3A%2F%2Fpic3.16pic.com%2F00%2F02%2F99%2F16pic_299414_b.jpg")
                .centerCrop().into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MvHolder extends RecyclerView.ViewHolder {
        public ImageView iv;

        public MvHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_item);
            ViewGroup.LayoutParams params = iv.getLayoutParams();
            params.width = itemWidth;
            params.height = itemHeight;
            iv.setLayoutParams(params);
        }
    }
}
