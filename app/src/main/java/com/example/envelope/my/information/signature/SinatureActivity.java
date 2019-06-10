package com.example.envelope.my.information.signature;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.envelope.R;
import com.example.envelope.utils.BaseActivity;
import com.example.envelope.utils.TitlebarUtile;
import com.example.envelope.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 修改签名
 * Created by wangxian on 2019/6/10
 **/
public class SinatureActivity extends BaseActivity {

    /**
     * 标题栏
     */
    @BindView(R.id.aty_sinature_title)
    TitlebarUtile atySinatureTitle;

    /**
     * 输入框
     */
    @BindView(R.id.aty_sinature_et_modifier)
    EditText atySinatureEtModifier;

    private String sinature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_sinature);
        ButterKnife.bind(this);
        initData();
        initView();
        initEvent();
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        sinature = intent.getStringExtra("signature") + "";
    }

    @Override
    public void initView() {
        atySinatureTitle.setRightTextSize(14);
        atySinatureTitle.setRightMargins(0, 0, 16, 0);
        atySinatureEtModifier.setText(sinature);
        atySinatureEtModifier.requestFocus();//获取焦点
        atySinatureEtModifier.setFocusable(true);
        atySinatureEtModifier.setSelection(atySinatureEtModifier.getText().length());
        //弹出软键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams
                .SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

    @Override
    public void initEvent() {
        atySinatureTitle.setOnViewClick(new TitlebarUtile.onViewClick() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {
                ToastUtil.showShort(SinatureActivity.this, "保存成功");
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
