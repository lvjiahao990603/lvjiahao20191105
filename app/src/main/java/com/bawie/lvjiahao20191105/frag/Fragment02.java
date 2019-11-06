package com.bawie.lvjiahao20191105.frag;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawie.lvjiahao20191105.R;
import com.bawie.lvjiahao20191105.adapte.MyAdapter;
import com.bawie.lvjiahao20191105.base.BaseFragment;
import com.bawie.lvjiahao20191105.bean.ShowBean;
import com.bawie.lvjiahao20191105.contract.IHomeContract;
import com.bawie.lvjiahao20191105.presenter.HomePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author: 吕佳豪
 * data: 2019/11/5 09:9:13
 * function:列表展示
 */
public class Fragment02 extends BaseFragment implements IHomeContract.Iview {

    private HomePresenter homePresenter;
    private GridLayoutManager gridLayoutManager;
    private RecyclerView recy;
    public final String TAG="Fragment01";

    @Override
    protected void initData() {
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        homePresenter.getShowPresenter("1","3");
    }

    @Override
    protected void initView(View view) {
        recy = view.findViewById(R.id.recy);
    }

    @Override
    protected int getlayout() {
        return R.layout.fragment02;
    }

    @Override
    public void onHomeGetShowSuccess(ShowBean data) {
        //log打印
        Log.d(TAG, "onHomeGetShowSuccess: "+data);
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recy.setLayoutManager(gridLayoutManager);
        List<ShowBean.ResultBean.PzshBean.CommodityListBeanX> commodityList = data.getResult().getPzsh().getCommodityList();
        MyAdapter myAdapter = new MyAdapter(getActivity(), commodityList);
        recy.setAdapter(myAdapter);
    }

    @Override
    public void onHomeGetShowFailure(String e) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        homePresenter.detachView();
    }
}