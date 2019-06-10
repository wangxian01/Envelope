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
 * 注册页面
 * Created by wangxian on 2019/6/4
 **/
public class RegisterActivity extends BaseActivity {

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

    /**
     * 标题栏
     */
    @BindView(R.id.aty_register_title)
    TitlebarUtile atyRegisterTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_register);
        ButterKnife.bind(this);

        initData();
        initView();
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
        registerTvGetvc.setOnClickListener(this);
        registerTvRe.setOnClickListener(this);
        atyRegisterTitle.setOnViewClick(new TitlebarUtile.onViewClick() {
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
