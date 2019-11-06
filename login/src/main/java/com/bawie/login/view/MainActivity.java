package com.bawie.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements IHomeContract.Iview {

    @BindView(R.id.login_phone)
    EditText login_phone;
    @BindView(R.id.login_pwd)
    EditText login_pwd;
    @BindView(R.id.login_jizhu)
    CheckBox login_jizhu;
    @BindView(R.id.login_register)
    TextView login_register;
    @BindView(R.id.login_login)
    Button login_login;
    private HomePresenter homePresenter;

    @Override
    protected void initData() {
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        //快速注册
        login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        //登录
        login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = login_phone.getText().toString().trim();
                String pwd = login_pwd.getText().toString().trim();
                if (TextUtils.isEmpty(phone)||TextUtils.isEmpty(pwd)){
                    Toast.makeText(MainActivity.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    homePresenter.postLoginPresenter(phone,pwd);
                }
            }
        });
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

    @OnClick({R.id.login_register, R.id.login_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_register:
                break;
            case R.id.login_login:
                break;
        }
    }

    @Override
    public void onHomePostLoginSuccess(LoginBean data) {
        String message = data.getMessage();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        if (message.equals("登录成功")){
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,ShowActivity.class);
            startActivity(intent);
        }
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
