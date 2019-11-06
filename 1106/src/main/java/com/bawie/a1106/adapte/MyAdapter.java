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
 * data: 2019/11/6 11:11:00
 * function:
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ShowBean.ResultBean.RxxpBean.CommodityListBean> list;
    Context context;
    private View inflate;

    public MyAdapter(FragmentActivity activity, List<ShowBean.ResultBean.RxxpBean.CommodityListBean> commodityList) {
        this.list=commodityList;
        this.context=activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflate = LayoutInflater.from(context).inflate(R.layout.item_gri, null);
        return new myViewHolderGri(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof myViewHolderGri){
            ((myViewHolderGri) viewHolder).gri_text_1.setText(list.get(i).getCommodityName());
            Glide.with(context).load(list.get(i).getMasterPic())
                    .error(R.mipmap.ic_launcher_round)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(((myViewHolderGri) viewHolder).gri_img_1);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class myViewHolderGri extends RecyclerView.ViewHolder {

        private final ImageView gri_img_1;
        private final TextView gri_text_1;
        private final TextView gri_text_2;
        private final LinearLayout line_gri;

        public myViewHolderGri(View inflate) {
            super(inflate);
            gri_img_1 = inflate.findViewById(R.id.gri_img_1);
            gri_text_1 = inflate.findViewById(R.id.gri_text_1);
            gri_text_2 = inflate.findViewById(R.id.gri_text_2);
            line_gri = inflate.findViewById(R.id.line_gri);
        }
    }
}
