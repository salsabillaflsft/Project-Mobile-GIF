package com.example.myapplication.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.search.GifSearchResultsItem;

import java.util.ArrayList;

public class GifSearchAdapter extends RecyclerView.Adapter<GifSearchAdapter.ViewHolder> {

    private ArrayList<GifSearchResultsItem> gifSearchResultsItems = new ArrayList<>();

    private Context context;

    public GifSearchAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<GifSearchResultsItem> items){
        gifSearchResultsItems.clear();
        gifSearchResultsItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gif_base,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context)
                .load(gifSearchResultsItems.get(position).getMedia().get(0).getGif())
                .into(holder.ivThumbnail)
        ;

        /*holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                String name = gifSearchResultsItems.get(position).getTitle();
                String gif = gifSearchResultsItems.get(position).getMedia().get(0).getGif().getUrl();
                String itemUrl = gifSearchResultsItems.get(position).getItemurl();
                if (name.isEmpty()){
                    String[] item;
                    item = itemUrl.split("/");
//                    name = item[item.length-1];
                    item = item[item.length-1].split("-");
                    name = item[0];
                }
                intent.putExtra("shares",gifSearchResultsItems.get(position).getShares());
                intent.putExtra("id_gif",gifSearchResultsItems.get(position).getId());
                intent.putExtra("name",name);
                intent.putExtra("gif",gif);
                context.startActivity(intent);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return gifSearchResultsItems.size();
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
