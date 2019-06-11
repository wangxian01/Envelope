package com.example.envelope.my.setting;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.envelope.R;
import com.example.envelope.utils.BaseActivity;
import com.example.envelope.utils.DialogUtils;
import com.example.envelope.utils.TitlebarUtile;
import com.example.envelope.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * 设置页面
 * Created by wangxian on 2019/6/11
 **/
public class SettingActivity extends BaseActivity {

    /**
     * 标题栏
     */
    @BindView(R.id.setting_title)
    TitlebarUtile settingTitle;

    /**
     * 版本
     */
    @BindView(R.id.settinge_rl_version)
    RelativeLayout settingeRlVersion;

    /**
     * 退出账号
     */
    @BindView(R.id.setting_rl_return_account)
    RelativeLayout settingRlReturnAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_setting);
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

        settingTitle.setOnViewClick(new TitlebarUtile.onViewClick() {
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
    public void initEvent() {
        settingeRlVersion.setOnClickListener(this);
        settingRlReturnAccount.setOnClickListener(this);
        settingTitle.setOnViewClick(new TitlebarUtile.onViewClick() {
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
        switch (v.getId()){
            case R.id.setting_rl_return_account:
                showExitAccount();
                break;
            case R.id.settinge_rl_version:

                break;
            default:break;
        }
    }

    /**
     * 退出账号
     */
    private void showExitAccount(){
        DialogUtils.showDialog(SettingActivity.this, "退出账号",
                "退出后不会删除任何历史数据,下次登录依然可以使用本账号",
                "取消",
                "确定",
                true,
                (dialog, which) -> dialog.dismiss(),
                (dialog, which) -> {
                    // TODO: 2019/6/11 退出逻辑暂留
                    ToastUtil.showShort(SettingActivity.this,"退出成功");
                    dialog.dismiss();
                });
    }
}
