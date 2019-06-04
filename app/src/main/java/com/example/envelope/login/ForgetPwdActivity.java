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
 * 忘记密码页面
 * Created by wangxian on 2019/6/4
 **/
public class ForgetPwdActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 返回
     */
    @BindView(R.id.forget_img_back)
    ImageView forgetImgBack;

    /**
     * 输入账号
     */
    @BindView(R.id.forget_et_account)
    EditText forgetEtAccount;

    /**
     * 输入验证码
     */
    @BindView(R.id.forget_et_vc)
    EditText forgetEtVc;

    /**
     * 获取验证码
     */
    @BindView(R.id.forget_tv_getvc)
    TextView forgetTvGetvc;

    /**
     * 输入新密码
     */
    @BindView(R.id.forget_et_newpaw)
    EditText forgetEtNewpaw;

    /**
     * 确认密码
     */
    @BindView(R.id.forget_et_surepaw)
    EditText forgetEtSurepaw;

    /**
     * 确定按钮
     */
    @BindView(R.id.forget_tv_sure)
    TextView forgetTvSure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);
        ButterKnife.bind(this);
        initEvent();
    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        forgetImgBack.setOnClickListener(this);
        forgetTvGetvc.setOnClickListener(this);
        forgetTvSure.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //返回按钮
            case R.id.forget_img_back:
                finish();
                break;
            //获取验证码
            case R.id.forget_tv_getvc:
                break;
            //确认按钮
            case R.id.forget_tv_sure:
                break;
            default:
                break;
        }
    }
}
