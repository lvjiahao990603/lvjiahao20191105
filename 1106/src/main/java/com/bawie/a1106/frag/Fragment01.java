package com.bawie.a1106.frag;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bawie.a1106.R;
import com.bawie.a1106.adapte.MyAdapter;
import com.bawie.a1106.adapte.MyAdapterLine;
import com.bawie.a1106.adapte.MyAdapterSta;
import com.bawie.a1106.base.BaseFragment;
import com.bawie.a1106.bean.LoginBean;
import com.bawie.a1106.bean.RegisterBean;
import com.bawie.a1106.bean.ShopBean;
import com.bawie.a1106.bean.ShowBean;
import com.bawie.a1106.bean.XbannerBean;
import com.bawie.a1106.contract.IHomeContract;
import com.bawie.a1106.presenter.HomePresenter;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

/**
 * author: 吕佳豪
 * data: 2019/11/6 09:9:41
 * function:
 */
public class Fragment01 extends BaseFragment implements IHomeContract.Iview {

    private RecyclerView recy_gri;
    private RecyclerView recy_lin;
    private RecyclerView recy_sta;
    private HomePresenter homePresenter;
    private XBanner xba;
    public final String TAG="Fragment01";
    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    protected void initData() {
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        homePresenter.getShowPresenter("1","3");
        homePresenter.getXbannerPresenter();

    }

    @Override
    protected void initView(View view) {
        recy_gri = view.findViewById(R.id.recy_gri);
        recy_lin = view.findViewById(R.id.recy_lin);
        recy_sta = view.findViewById(R.id.recy_sta);
        xba = view.findViewById(R.id.xba);
    }

    @Override
    protected int getlayout() {
        return R.layout.fragment01;
    }

    @Override
    public void onHomePostLoginSuccess(LoginBean data) {

    }

    @Override
    public void onHomePostLoginFailure(String e) {

    }

    @Override
    public void onHomePostRegisterSuccess(RegisterBean data) {

    }

    @Override
    public void onHomePostRegisterFailure(String e) {

    }

    @Override
    public void onHomeGetXbannerSuccess(XbannerBean data) {
        Log.d(TAG, "onHomeGetXbannerSuccess: "+data);
        final List<XbannerBean.ResultBean> result = data.getResult();
        xba.setData(result,null);
        xba.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(getActivity()).load(result.get(position).getImageUrl())
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher_round)
                        .into((ImageView) view);
            }
        });
    }

    @Override
    public void onHomeGetXbannerFailure(String e) {

    }

    @Override
    public void onHomeGetShowSuccess(ShowBean data) {
        //Grild
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recy_gri.setLayoutManager(gridLayoutManager);
        List<ShowBean.ResultBean.RxxpBean.CommodityListBean> commodityList = data.getResult().getRxxp().getCommodityList();
        MyAdapter myAdapter = new MyAdapter(getActivity(), commodityList);
        recy_gri.setAdapter(myAdapter);
        //line
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recy_lin.setLayoutManager(linearLayoutManager);
        List<ShowBean.ResultBean.PzshBean.CommodityListBeanX> commodityList1 = data.getResult().getPzsh().getCommodityList();
        MyAdapterLine myAdapterLine = new MyAdapterLine(getActivity(), commodityList1);
        recy_lin.setAdapter(myAdapterLine);
        //sta
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recy_sta.setLayoutManager(staggeredGridLayoutManager);
        List<ShowBean.ResultBean.MlssBean.CommodityListBeanXX> commodityList2 = data.getResult().getMlss().getCommodityList();
        MyAdapterSta myAdapterSta = new MyAdapterSta(getActivity(), commodityList2);
        recy_sta.setAdapter(myAdapterSta);
    }

    @Override
    public void onHomeGetShowFailure(String e) {

    }

    @Override
    public void onHomeGetShopSuccess(ShopBean data) {

    }

    @Override
    public void onHomeGetShopFailure(String e) {

    }
}
