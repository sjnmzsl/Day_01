package com.example.one.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.one.R;
import com.example.one.bean.JournalismBean;

import java.util.ArrayList;

public class RecyAdapter_JournFra extends RecyclerView.Adapter {
    private Activity activity;
    private ArrayList<JournalismBean.NewsDTO> arr;

    public RecyAdapter_JournFra(Activity activity, ArrayList<JournalismBean.NewsDTO> arr) {
        this.activity = activity;
        this.arr = arr;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_recy, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh= (ViewHolder) holder;
        JournalismBean.NewsDTO bean = arr.get(position);
        Glide.with(activity).load(bean.getImageUrl()).into(vh.ima_recy);
        vh.tv_desc.setText(bean.getContent());
        vh.tv_title.setText(bean.getTile());
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }
    private class  ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView ima_recy;
        private final TextView tv_title;
        private final TextView tv_desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.ima_recy=itemView.findViewById(R.id.ima_recy);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_desc=itemView.findViewById(R.id.tv_desc);
        }
    }
}
