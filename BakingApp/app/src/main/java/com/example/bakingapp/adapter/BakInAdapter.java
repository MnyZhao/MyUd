package com.example.bakingapp.adapter;

import android.content.Context;
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

public class BakInAdapter extends RecyclerView.Adapter<BakInAdapter.BakViewHolder> {
    Context context;
    List<Baking.IngredientsBean> list;

    public BakInAdapter() {
    }

    public BakInAdapter(Context context, List<Baking.IngredientsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public BakViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BakViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_in, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BakViewHolder holder, final int position) {
        holder.tvTitle.setText(list.get(position).getIngredient());
        holder.tvNum.setText(list.get(position).getQuantity());
        holder.tvM.setText(list.get(position).getMeasure());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class BakViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvNum;
        TextView tvM;

        public BakViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvNum = itemView.findViewById(R.id.tv_num);
            tvNum = itemView.findViewById(R.id.tv_num_m);
        }
    }
}
