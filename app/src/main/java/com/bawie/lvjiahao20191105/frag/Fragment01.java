package com.bawie.lvjiahao20191105.frag;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawie.lvjiahao20191105.R;
import com.bawie.lvjiahao20191105.base.BaseFragment;
import com.bawie.lvjiahao20191105.view.MainActivity;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * author: 吕佳豪
 * data: 2019/11/5 09:9:12
 * function:
 */
public class Fragment01 extends BaseFragment {

    private ImageView img_sao;
    private EditText et_logo;
    private Button bt_logo;
    private ImageView img_1;

    @Override
    protected void initData() {
        ZXingLibrary.initDisplayOpinion(getActivity());
        //生成二维码图片
        bt_logo.setOnClickListener(new View.OnClickListener() {

            private Bitmap mBitmap;

            @Override
            public void onClick(View v) {
                String textContent = et_logo.getText().toString();
                if (TextUtils.isEmpty(textContent)) {
                    Toast.makeText(getActivity(), "您的输入为空!", Toast.LENGTH_SHORT).show();
                    return;
                }
                et_logo.setText("");
                mBitmap = CodeUtils.createImage(textContent, 400, 400, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                img_1.setImageBitmap(mBitmap);
            }
        });
        //扫描
        img_sao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, Activity.RESULT_CANCELED);

            }

        });
    }

    @Override
    protected void initView(View view) {
        img_sao = view.findViewById(R.id.img_sao);
        et_logo = view.findViewById(R.id.et_logo);
        bt_logo = view.findViewById(R.id.bt_logo);
        img_1 = view.findViewById(R.id.img_1);
    }

    @Override
    protected int getlayout() {
        return R.layout.fragment01;
    }
}
