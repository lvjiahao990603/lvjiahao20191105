package com.bawie.a1106.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawie.a1106.R;
import com.bawie.a1106.base.BaseActivity;
import com.bawie.a1106.bean.LoginBean;
import com.bawie.a1106.bean.RegisterBean;
import com.bawie.a1106.bean.ShopBean;
import com.bawie.a1106.bean.ShowBean;
import com.bawie.a1106.bean.XbannerBean;
import com.bawie.a1106.contract.IHomeContract;
import com.bawie.a1106.presenter.HomePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements IHomeContract.Iview  {

    @BindView(R.id.login_phone)
    EditText loginPhone;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.login_jizhu)
    CheckBox loginJizhu;
    @BindView(R.id.login_register)
    TextView loginRegister;
    @BindView(R.id.login_login)
    Button loginLogin;
    private HomePresenter homePresenter;
//    private EditText login_phone;
//    private EditText login_pwd;
//    private CheckBox login_jizhu;
//    private Button login_login;
//    private TextView login_register;

    @Override
    protected void initData() {
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        //快速注册
        loginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        //登录
        loginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone1 = loginPhone.getText().toString().trim();
                String pwd1 = loginPwd.getText().toString().trim();
                if (TextUtils.isEmpty(phone1) || TextUtils.isEmpty(pwd1)) {
                    Toast.makeText(MainActivity.this, "手机号或密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    homePresenter.postLoginPresenter(phone1, pwd1);
                }
            }
        });
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);

//        login_phone = findViewById(R.id.login_phone);
//        login_pwd = findViewById(R.id.login_pwd);
//        login_jizhu = findViewById(R.id.login_jizhu);
//        login_login = findViewById(R.id.login_login);
//        login_register = findViewById(R.id.login_register);
    }

    @Override
    protected int getlayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onHomePostLoginSuccess(LoginBean data) {
        String message = data.getMessage();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        if (message.equals("登录成功")) {
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ShowActivity.class);
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

    @Override
    public void onHomeGetShopSuccess(ShopBean data) {

    }

    @Override
    public void onHomeGetShopFailure(String e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
    }
}
