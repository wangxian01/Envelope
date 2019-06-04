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
 * 注册页面
 * Created by wangxian on 2019/6/4
 **/
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 返回按钮
     */
    @BindView(R.id.register_img_back)
    ImageView registerImgBack;

    /**
     * 注册账号
     */
    @BindView(R.id.register_et_account)
    EditText registerEtAccount;

    /**
     * 输入验证码
     */
    @BindView(R.id.register_et_vc)
    EditText registerEtVc;

    /**
     * 获取验证码
     */
    @BindView(R.id.register_tv_getvc)
    TextView registerTvGetvc;

    /**
     * 输入密码
     */
    @BindView(R.id.register_et_paw)
    EditText registerEtPaw;

    /**
     * 注册按钮
     */
    @BindView(R.id.register_tv_re)
    TextView registerTvRe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_register);
        ButterKnife.bind(this);
        initEvent();
    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        registerImgBack.setOnClickListener(this);
        registerTvGetvc.setOnClickListener(this);
        registerTvRe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //返回按钮
            case R.id.register_img_back:
                finish();
                break;
            //获取验证码
            case R.id.register_tv_getvc:
                break;
            //注册按钮
            case R.id.register_tv_re:
                break;
            default:
                break;
        }
    }
}
