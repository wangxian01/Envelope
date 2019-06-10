package com.example.envelope.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.envelope.R;
import com.example.envelope.utils.BaseActivity;
import com.example.envelope.utils.TitlebarUtile;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 微信登录资料完善页面
 * Created by wangxian on 2019/6/3
 **/
public class WxLoginActivity extends BaseActivity {

    /**
     * 手机号
     */
    @BindView(R.id.wxlogin_et_account)
    EditText wxloginEtAccount;

    /**
     * 输入验证码
     */
    @BindView(R.id.wxlogin_et_vc)
    EditText wxloginEtVc;

    /**
     * 获取验证码
     */
    @BindView(R.id.wxlogin_tv_getvc)
    TextView wxloginTvGetvc;

    /**
     * 确认
     */
    @BindView(R.id.wxlogin_tv_sure)
    TextView wxloginTvSure;

    /**
     * 标题栏
     */
    @BindView(R.id.aty_wx_login_title)
    TitlebarUtile atyWxLoginTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx_login);
        ButterKnife.bind(this);
        initEvent();
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    /**
     * 初始化事件
     */
    @Override
    public void initEvent() {
        wxloginTvGetvc.setOnClickListener(this);
        wxloginTvSure.setOnClickListener(this);
        atyWxLoginTitle.setOnViewClick(new TitlebarUtile.onViewClick() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //获取验证码
            case R.id.wxlogin_tv_getvc:
                break;
            //确认
            case R.id.wxlogin_tv_sure:
                break;
            default:
                break;
        }
    }
}
