package com.example.envelope.my.shopping;

import android.os.Bundle;
import android.view.View;

import com.example.envelope.R;
import com.example.envelope.utils.BaseActivity;
import com.example.envelope.utils.TitlebarUtile;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 购物车页面
 * Created by wangxian on 2019/6/10
 **/
public class ShoppingActivity extends BaseActivity {

    /**
     * 标题栏
     */
    @BindView(R.id.shopping_title)
    TitlebarUtile shoppingTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_shopping);
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
        //设置标题文字大小
        shoppingTitle.setTitleSize(16);
    }

    @Override
    public void initEvent() {

        shoppingTitle.setOnViewClick(new TitlebarUtile.onViewClick() {
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

    }


}
