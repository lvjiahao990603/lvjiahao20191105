package com.bawie.a1106.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
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

public class RegisterActivity extends BaseActivity implements IHomeContract.Iview {

    @BindView(R.id.register_back)
    TextView registerBack;
    @BindView(R.id.register_phone)
    EditText registerPhone;
    @BindView(R.id.register_pwd)
    EditText registerPwd;
    @BindView(R.id.register_yiyou)
    TextView registerYiyou;
    @BindView(R.id.register_register)
    Button registerRegister;
//    private TextView register_back;
//    private EditText register_phone;
//    private EditText register_pwd;
//    private TextView register_yiyou;
//    private Button register_register;
    private HomePresenter homePresenter;

    @Override
    protected void initData() {
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        //已有账号
        registerYiyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //返回
        registerBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //注册
        registerRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = registerPhone.getText().toString().trim();
                String pwd = registerPwd.getText().toString().trim();
                if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(pwd)) {
                    Toast.makeText(RegisterActivity.this, "手机号或密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    homePresenter.postRegisterPresenter(phone, pwd);
                }
            }
        });
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
//        register_back = findViewById(R.id.register_back);
//        register_phone = findViewById(R.id.register_phone);
//        register_pwd = findViewById(R.id.register_pwd);
//        register_yiyou = findViewById(R.id.register_yiyou);
//        register_register = findViewById(R.id.register_register);
    }

    @Override
    protected int getlayout() {
        return R.layout.activity_register;
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
        if (message.equals("注册成功")) {
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
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
