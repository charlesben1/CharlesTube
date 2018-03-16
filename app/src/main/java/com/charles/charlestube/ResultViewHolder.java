package com.charles.charlestube;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.charles.charlestube.Item;
import com.charles.charlestube.R;
import com.charles.charlestube.onResultSelectedListener;

/**
 * Created by charles on 16/03/2018.
 */


public class ResultViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView author;
    private com.charles.charlestube.onResultSelectedListener onResultSelectedListener;
    public ImageView mImg;


    public ResultViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.Title);
        author = (TextView) itemView.findViewById(R.id.Author);
        mImg = (ImageView) itemView.findViewById(R.id.thumb);
    }

    public void bind(final Item result){
        title.setText(result.getSnippet().getTitle());
        author.setText(result.getSnippet().channelTitle);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onResultSelectedListener == null) {
                    return;
                }
                onResultSelectedListener.onResultSelected(result);
            }
        });

    }

    public void setOnResultSelectedListener(onResultSelectedListener onResultSelectedListener) {
        this.onResultSelectedListener = onResultSelectedListener;
    }

}
