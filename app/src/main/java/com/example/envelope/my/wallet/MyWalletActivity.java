package com.example.envelope.my.wallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.envelope.R;
import com.example.envelope.utils.BaseActivity;
import com.example.envelope.utils.TitlebarUtile;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 我的钱包
 * Created by wangxian on 2019/6/5
 **/
public class MyWalletActivity extends BaseActivity {

    /**
     * 标题栏
     */
    @BindView(R.id.aty_wallet_title)
    TitlebarUtile atyWalletTitle;

    /**
     * 我的余额
     */
    @BindView(R.id.aty_wallet_tv_money)
    TextView atyWalletTvMoney;

    /**
     * 提现
     */
    @BindView(R.id.aty_wallet_tv_withdraw)
    TextView atyWalletTvWithdraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_my_wallet);
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
        atyWalletTitle.setTitleSize(16);
        atyWalletTitle.setRightTextSize(12);
    }

    @Override
    public void initEvent() {
        atyWalletTitle.setOnViewClick(new TitlebarUtile.onViewClick() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {
                Intent intent = new Intent(MyWalletActivity.this,RecordActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
