package com.charles.charlestube;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.charles.charlestube.Item;
import com.charles.charlestube.SearchResult;
import com.charles.charlestube.R;
import com.charles.charlestube.ResultViewHolder;
import com.charles.charlestube.onResultSelectedListener;

import java.util.List;

/**
 * Created by charles on 16/03/2018.
 */

public class ResultAdapter extends RecyclerView.Adapter<ResultViewHolder> {

    private final SearchResult result;
    private final List<Item> items;
    private com.charles.charlestube.onResultSelectedListener onResultSelectedListener;

    Context context;


    public ResultAdapter( Context context, SearchResult result){
        this.context=context;
        this.result = result;
        this.items = result.getItems();
        Log.v("items",items.toString());

    }

    @Override
    public ResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_viewholder, parent, false);

        ResultViewHolder holder = new ResultViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ResultViewHolder holder, int position) {
        holder.setOnResultSelectedListener(onResultSelectedListener);
        holder.bind(items.get(position));

        Glide.with(context).load(items.get(position).getSnippet().getThumbnails().getHigh().getUrl())
                .thumbnail(0.5f)
                .override(200, 200)
                .crossFade()
                .diskCacheStrategy( DiskCacheStrategy.ALL)
                .into(((ResultViewHolder) holder).mImg);
    }



    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    public void setOnResultSelectedListener(onResultSelectedListener onResultSelectedListener) {
        this.onResultSelectedListener = onResultSelectedListener;
    }
}
