package com.example.envelope.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.envelope.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 微信登录资料完善页面
 * Created by wangxian on 2019/6/3
 **/
public class WxLoginActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 返回按钮
     */
    @BindView(R.id.wxlogin_img_back)
    ImageView wxloginImgBack;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx_login);
        ButterKnife.bind(this);
        initEvent();
    }

    /**
     * 初始化事件
     */
    private void initEvent() {

        wxloginImgBack.setOnClickListener(this);
        wxloginTvGetvc.setOnClickListener(this);
        wxloginTvSure.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //返回
            case R.id.wxlogin_img_back:
                finish();
                break;
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
