package com.example.envelope.my.information;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.envelope.R;
import com.example.envelope.utils.BaseActivity;
import com.example.envelope.utils.TitlebarUtile;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 我的信息
 * Created by wangxian on 2019/6/6
 **/
public class MyInformationActivity extends BaseActivity {

    /**
     * 封装好的标题栏
     */
    @BindView(R.id.imformation_title)
    TitlebarUtile imformationTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_my_information);
        ButterKnife.bind(this);
        initData();
        initView();
        initEvent();
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(){
        //设置标题文字大小
        imformationTitle.setTitleSize(16);
    }

    @Override
    public void initEvent(){

        imformationTitle.setOnViewClick(new TitlebarUtile.onViewClick() {
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

        }
    }
}
