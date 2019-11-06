package com.bawie.lvjiahao20191105.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.bawie.lvjiahao20191105.R;
import com.bawie.lvjiahao20191105.base.BaseActivity;
import com.bawie.lvjiahao20191105.frag.Fragment01;
import com.bawie.lvjiahao20191105.frag.Fragment02;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
/**
 *@describe(描述)：MainActivity
 *@data（日期）: 2019/11/5
 *@time（时间）: 9:19
 *@author（作者）:吕佳豪
 **/
public class MainActivity extends BaseActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab)
    TabLayout tab;
    ArrayList<Fragment>fragments=new ArrayList<>();
    ArrayList<String>strings=new ArrayList<>();
    @Override
    protected void initData() {
        
        
        
        fragments.add(new Fragment01());
        fragments.add(new Fragment02());

        strings.add("首页");
        strings.add("列表");

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return strings.get(position);
            }
        });
        tab.setupWithViewPager(vp);
        Toast.makeText(this, "网络请求成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected int getlayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
