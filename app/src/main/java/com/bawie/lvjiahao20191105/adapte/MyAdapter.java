package com.bawie.lvjiahao20191105.adapte;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.lvjiahao20191105.R;
import com.bawie.lvjiahao20191105.bean.ShowBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * author: 吕佳豪
 * data: 2019/11/5 09:9:45
 * function:适配器
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ShowBean.ResultBean.PzshBean.CommodityListBeanX> list;
    Context context;
    private View inflate;

    public MyAdapter(FragmentActivity activity, List<ShowBean.ResultBean.PzshBean.CommodityListBeanX> commodityList) {
        this.list=commodityList;
        this.context=activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflate = LayoutInflater.from(context).inflate(R.layout.lay01, null);
        return new myViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof myViewHolder){
            ((myViewHolder) viewHolder).lay_text_1.setText(list.get(i).getCommodityName());
            ((myViewHolder) viewHolder).lay_text_2.setText(list.get(i).getPrice());
            Glide.with(context).load(list.get(i).getMasterPic())
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .into(((myViewHolder) viewHolder).lay_img_1);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class myViewHolder extends RecyclerView.ViewHolder {

        private final ImageView lay_img_1;
        private final TextView lay_text_1;
        private final TextView lay_text_2;

        public myViewHolder(View inflate) {
            super(inflate);
            lay_img_1 = inflate.findViewById(R.id.lay_img_1);
            lay_text_1 = inflate.findViewById(R.id.lay_text_1);
            lay_text_2 = inflate.findViewById(R.id.lay_text_2);
        }
    }
}
