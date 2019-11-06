package com.bawie.a1106.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.bawie.a1106.R;
import com.bawie.a1106.base.BaseActivity;
import com.bawie.a1106.frag.Fragment01;
import com.bawie.a1106.frag.Fragment02;
import com.bawie.a1106.frag.Fragment03;
import com.bawie.a1106.frag.Fragment04;
import com.bawie.a1106.frag.Fragment05;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends BaseActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab)
    TabLayout tab;
    ArrayList<Fragment>fragments=new ArrayList<>();
    @Override
    protected void initData() {
        fragments.add(new Fragment01());
        fragments.add(new Fragment02());
        fragments.add(new Fragment03());
        fragments.add(new Fragment04());
        fragments.add(new Fragment05());

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setIcon(R.mipmap.one);
        tab.getTabAt(1).setIcon(R.mipmap.two);
        tab.getTabAt(2).setIcon(R.mipmap.three);
        tab.getTabAt(3).setIcon(R.mipmap.four);
        tab.getTabAt(4).setIcon(R.mipmap.five);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected int getlayout() {
        return R.layout.activity_show;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
    }
}
