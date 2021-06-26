package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.trending.GifTrendingResultsItem;

import java.util.ArrayList;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.ViewHolder> {

    private ArrayList<GifTrendingResultsItem> gifTrendingResultsItems = new ArrayList<>();
    private Context context;
    public TrendingAdapter(Context context) {
        this.context = context;
    }
    public void setData(ArrayList<GifTrendingResultsItem> items){
        gifTrendingResultsItems.clear();
        gifTrendingResultsItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.gif_base,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context)
                .load(gifTrendingResultsItems.get(position).getMedia().get(0).getGif().getUrl())
                .into(holder.ivThumbnail);
    }

    @Override
    public int getItemCount() {
        return gifTrendingResultsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumbnail;
        CardView cvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.gif_thumbnail);
            cvItem = itemView.findViewById(R.id.gif_list);
        }
    }
}

