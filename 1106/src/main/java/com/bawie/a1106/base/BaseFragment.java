package com.bawie.a1106.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * author: 吕佳豪
 * data: 2019/11/6 08:8:50
 * function:
 */
public abstract class BaseFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), getlayout(), null);
        initView(view);
        initData();
        return view;
    }

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract int getlayout();
}
