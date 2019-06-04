package com.example.envelope.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.envelope.R;
import com.example.envelope.index.IndexActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 登录页面
 * Created by wangxian on 2019/6/3
 **/
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 选择密码登录
     */
    @BindView(R.id.login_tv_paw)
    TextView loginTvPaw;

    /**
     * 选择验证码登录
     */
    @BindView(R.id.login_tv_vc)
    TextView loginTvVc;

    /**
     * 输入账号
     */
    @BindView(R.id.login_et_account)
    EditText loginEtAccount;

    /**
     * 输入密码
     */
    @BindView(R.id.login_et_wd)
    EditText loginEtWd;

    /**
     * 获取验证码
     */
    @BindView(R.id.login_tv_getvc)
    TextView loginTvGetvc;

    /**
     * 忘记密码
     */
    @BindView(R.id.login_tv_forget_pwd)
    TextView loginTvForgetPwd;

    /**
     * 注册
     */
    @BindView(R.id.login_tv_register)
    TextView loginTvRegister;

    /**
     * 忘记和注册布局
     */
    @BindView(R.id.login_rt_register)
    RelativeLayout loginRtRegister;

    /**
     * 登录按钮
     */
    @BindView(R.id.login_tv_lg)
    TextView loginTvLg;

    /**
     * 微信登录
     */
    @BindView(R.id.login_wx)
    ImageView loginWx;

    private boolean choose = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_login);
        ButterKnife.bind(this);
        initEvent();
    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        loginTvForgetPwd.setOnClickListener(this);
        loginTvGetvc.setOnClickListener(this);
        loginTvLg.setOnClickListener(this);
        loginTvRegister.setOnClickListener(this);
        loginWx.setOnClickListener(this);
        loginTvPaw.setOnClickListener(this);
        loginTvVc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //选择密码登录
            case R.id.login_tv_paw:
                choosePaw();
                break;
            //选择验证码登录
            case R.id.login_tv_vc:
                chooseVc();
                break;
            //获取验证码
            case R.id.login_tv_getvc:
                break;
            //忘记密码
            case R.id.login_tv_forget_pwd:
                Intent intentForget = new Intent(LoginActivity.this,ForgetPwdActivity.class);
                startActivity(intentForget);
                break;
            //注册
            case R.id.login_tv_register:
                Intent intentRegister = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intentRegister);
                break;
            //登录按钮
            case R.id.login_tv_lg:
                // TODO: 2019/6/4 暂直接跳转主页面
                Intent intentIndex = new Intent(LoginActivity.this, IndexActivity.class);
                startActivity(intentIndex);
                break;
            //微信登录
            case R.id.login_wx:
                // TODO: 2019/6/4 此处暂时跳转微信资料完善页面
                Intent intentWx = new Intent(LoginActivity.this,WxLoginActivity.class);
                startActivity(intentWx);
                break;
            default:
                break;
        }
    }

    /**
     * 选择密码登录
     */
    private void choosePaw() {
        choose = !choose;
        loginTvGetvc.setVisibility(View.INVISIBLE);
        loginRtRegister.setVisibility(View.VISIBLE);
        loginTvPaw.setBackgroundResource(R.drawable.tv_login_bg);
        loginTvVc.setBackgroundResource(R.color.colorWhite);
        loginEtWd.setHint("请输入密码");
    }

    /**
     * 选择验证码登录
     */
    private void chooseVc() {
        choose = !choose;
        loginTvGetvc.setVisibility(View.VISIBLE);
        loginRtRegister.setVisibility(View.INVISIBLE);
        loginTvVc.setBackgroundResource(R.drawable.tv_login_bg);
        loginTvPaw.setBackgroundResource(R.color.colorWhite);
        loginEtWd.setHint("请输入验证码");
    }
}
