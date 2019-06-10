package com.example.envelope.my.information.nickname;

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
 * 修改昵称
 * Created by wangxian on 2019/6/10
 **/
public class NickNameActivity extends BaseActivity {

    /**
     * 标题栏
     */
    @BindView(R.id.aty_name_title)
    TitlebarUtile atyNameTitle;

    /**
     * 昵称输入框
     */
    @BindView(R.id.aty_name_et_modifier)
    EditText atyNameEtModifier;

    private String nickName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_nick_name);
        ButterKnife.bind(this);
        initData();
        initView();
        initEvent();
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        nickName = intent.getStringExtra("name") + "";
    }

    @Override
    public void initView() {
        atyNameTitle.setRightTextSize(14);
        atyNameTitle.setRightMargins(0, 0, 16, 0);
        atyNameEtModifier.setText(nickName);
        atyNameEtModifier.requestFocus();//获取焦点
        atyNameEtModifier.setFocusable(true);
        atyNameEtModifier.setSelection(atyNameEtModifier.getText().length());
        //弹出软键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams
                .SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

    @Override
    public void initEvent() {
        atyNameTitle.setOnViewClick(new TitlebarUtile.onViewClick() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {
                ToastUtil.showShort(NickNameActivity.this, "保存成功");
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
