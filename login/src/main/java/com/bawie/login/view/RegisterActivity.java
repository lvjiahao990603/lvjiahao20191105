package com.bawie.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawie.login.R;
import com.bawie.login.base.BaseActivity;
import com.bawie.login.bean.LoginBean;
import com.bawie.login.bean.RegisterBean;
import com.bawie.login.bean.ShowBean;
import com.bawie.login.bean.XbannerBean;
import com.bawie.login.contract.IHomeContract;
import com.bawie.login.presenter.HomePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends BaseActivity implements IHomeContract.Iview {

    private HomePresenter homePresenter;
    private TextView register_back;
    private EditText register_phone;
    private EditText register_pwd;
    private TextView register_yiyou;
    private Button register_register;
    public final String TAG="RegisterActivity";

    @Override
    protected void initData() {
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        //已有账号
        register_yiyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //返回
        register_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //登录
        register_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone1 = register_phone.getText().toString().trim();
                String pwd1 = register_pwd.getText().toString().trim();
                if (TextUtils.isEmpty(phone1)||TextUtils.isEmpty(pwd1)){
                    Toast.makeText(RegisterActivity.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    homePresenter.postLoginPresenter(phone1,pwd1);
                }
            }
        });
    }

    @Override
    protected void initView() {
        register_back = findViewById(R.id.register_back);
        register_phone = findViewById(R.id.register_phone);
        register_pwd = findViewById(R.id.register_pwd);
        register_yiyou = findViewById(R.id.register_yiyou);
        register_register = findViewById(R.id.register_register);
    }

    @Override
    protected int getlayout() {
        return R.layout.activity_regieter;
    }

    @Override
    public void onHomePostLoginSuccess(LoginBean data) {

    }

    @Override
    public void onHomePostLoginFailure(String e) {

    }

    @Override
    public void onHomePostRegisterSuccess(RegisterBean data) {
        String message = data.getMessage();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            if (message.equals("注册成功")){
                Log.d(TAG, "onHomePostRegisterSuccess: "+data);
                Intent intent = new Intent(RegisterActivity.this,ShowActivity.class);
                startActivity(intent);
            }
        }

    @Override
    public void onHomePostRegisterFailure(String e) {

    }

    @Override
    public void onHomeGetXbannerSuccess(XbannerBean data) {

    }

    @Override
    public void onHomeGetXbannerFailure(String e) {

    }

    @Override
    public void onHomeGetShowSuccess(ShowBean data) {

    }

    @Override
    public void onHomeGetShowFailure(String e) {

    }
}
