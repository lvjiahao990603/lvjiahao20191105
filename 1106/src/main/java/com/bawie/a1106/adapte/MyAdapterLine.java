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
 * data: 2019/11/6 11:11:33
 * function:
 */
public class MyAdapterLine extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ShowBean.ResultBean.PzshBean.CommodityListBeanX> list;
    Context context;
    private View inflate;

    public MyAdapterLine(FragmentActivity activity, List<ShowBean.ResultBean.PzshBean.CommodityListBeanX> commodityList1) {
        this.list=commodityList1;
        this.context=activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflate = LayoutInflater.from(context).inflate(R.layout.item_lin, null);
        return new myViewHolderLin(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof myViewHolderLin){
            ((myViewHolderLin) viewHolder).lin_text_1.setText(list.get(i).getCommodityName());
            Glide.with(context).load(list.get(i).getMasterPic())
                    .error(R.mipmap.ic_launcher_round)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(((myViewHolderLin) viewHolder).lin_img_1);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class myViewHolderLin extends RecyclerView.ViewHolder {

        private final ImageView lin_img_1;
        private final TextView lin_text_1;
        private final TextView lin_text_2;
        private final LinearLayout line_lin;

        public myViewHolderLin(View inflate) {
            super(inflate);
            lin_img_1 = inflate.findViewById(R.id.lin_img_1);
            lin_text_1 = inflate.findViewById(R.id.lin_text_1);
            lin_text_2 = inflate.findViewById(R.id.lin_text_2);
            line_lin = inflate.findViewById(R.id.line_lin);
        }
    }
}
