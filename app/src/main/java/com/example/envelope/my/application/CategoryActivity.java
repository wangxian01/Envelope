package com.example.envelope.my.application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.envelope.R;
import com.example.envelope.utils.BaseActivity;
import com.example.envelope.utils.TitlebarUtile;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 选择商家类别
 * Created by wangxian on 2019/6/11
 **/
public class CategoryActivity extends BaseActivity {

    /**
     * 标题栏
     */
    @BindView(R.id.category_title)
    TitlebarUtile categoryTitle;

    /**
     * 选择类别
     */
    @BindView(R.id.category_rv_choose)
    RecyclerView categoryRvChoose;
    private ChooseCategoryAdapter adapter;
    private String[] category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_category);
        ButterKnife.bind(this);
        initData();
        initView();
        initEvent();
    }

    @Override
    public void initData() {
        category = new String[]{"餐饮","服装","教育培训","百货","酒店","服务行业","娱乐","数码","茶叶"
                ,"健身","珠宝","美容美发","医疗保健","汽车","其它"};
        adapter = new ChooseCategoryAdapter(this, R.layout.item_category_choose, category);
        categoryRvChoose.setLayoutManager(new LinearLayoutManager(this));
        categoryRvChoose.setNestedScrollingEnabled(false);
        categoryRvChoose.setAdapter(adapter);
    }

    @Override
    public void initView() {
        categoryTitle.setTitle("商家类别");
    }

    @Override
    public void initEvent() {
        categoryTitle.setOnViewClick(new TitlebarUtile.onViewClick() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {

            }
        });
        adapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(this,ApplicationActivity.class)
                    .putExtra(ApplicationActivity.merchant,category[position]);
            this.setResult(ApplicationActivity.MERCHANT_CATEGORY,intent);
            finish();
        });
    }

    @Override
    public void onClick(View v) {

    }
}
