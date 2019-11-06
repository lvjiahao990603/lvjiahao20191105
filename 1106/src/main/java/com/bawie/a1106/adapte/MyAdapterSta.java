package com.bawie.a1106.adapte;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawie.a1106.R;
import com.bawie.a1106.bean.ShowBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * author: 吕佳豪
 * data: 2019/11/6 11:11:50
 * function:
 */
public class MyAdapterSta extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ShowBean.ResultBean.MlssBean.CommodityListBeanXX> list;
    Context context;
    private View inflate;

    public MyAdapterSta(FragmentActivity activity, List<ShowBean.ResultBean.MlssBean.CommodityListBeanXX> commodityList2) {
        this.list=commodityList2;
        this.context=activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflate = LayoutInflater.from(context).inflate(R.layout.item_sta, null);
        return new myViewHolderSta(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof myViewHolderSta){
            ((myViewHolderSta) viewHolder).sta_text_1.setText(list.get(i).getCommodityName());
            Glide.with(context).load(list.get(i).getMasterPic())
                    .error(R.mipmap.ic_launcher_round)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(((myViewHolderSta) viewHolder).sta_img_1);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class myViewHolderSta extends RecyclerView.ViewHolder {

        private final ImageView sta_img_1;
        private final TextView sta_text_1;
        private final TextView sta_text_2;
        private final LinearLayout line_sta;

        public myViewHolderSta(View inflate) {
            super(inflate);
            sta_img_1 = inflate.findViewById(R.id.sta_img_1);
            sta_text_1 = inflate.findViewById(R.id.sta_text_1);
            sta_text_2 = inflate.findViewById(R.id.sta_text_2);
            line_sta = inflate.findViewById(R.id.line_sta);
        }
    }
}
