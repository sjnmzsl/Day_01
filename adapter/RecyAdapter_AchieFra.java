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
import com.example.one.bean.AchievementBean;
import com.example.one.bean.JournalismBean;

import java.util.ArrayList;

public class RecyAdapter_AchieFra extends RecyclerView.Adapter {
    private Activity activity;
    private ArrayList<AchievementBean.StudenlistDTO> arr;

    public RecyAdapter_AchieFra(Activity activity, ArrayList<AchievementBean.StudenlistDTO> arr) {
        this.activity = activity;
        this.arr = arr;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh= (ViewHolder) holder;
        AchievementBean.StudenlistDTO bean = arr.get(position);
        vh.tv_title_achieFra.setText("姓名是"+bean.getName());
        vh.tv_jiShi_achieFra.setText("机试成绩是"+bean.getSkill());
        vh.tv_liLun_achieFra.setText("理论成绩是"+bean.getSkill());
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }
    private class  ViewHolder extends RecyclerView.ViewHolder{


        private  TextView tv_jiShi_achieFra;
        private  TextView tv_liLun_achieFra;
        private  TextView tv_title_achieFra;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title_achieFra=itemView.findViewById(R.id.tv_title_achieFra);
            tv_jiShi_achieFra = itemView.findViewById(R.id.tv_jiShi_achieFra);
            tv_liLun_achieFra=itemView.findViewById(R.id.tv_liLun_achieFra);
        }
    }
}
