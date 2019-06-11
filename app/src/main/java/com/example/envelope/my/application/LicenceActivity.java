package com.example.envelope.my.application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.envelope.R;
import com.example.envelope.utils.BaseActivity;
import com.example.envelope.utils.TitlebarUtile;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 选择经营许可证类别
 * Created by wangxian on 2019/6/11
 **/
public class LicenceActivity extends BaseActivity {

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
        category = new String[]{"餐饮服务许可证","期刊出版许可证","危险化学平经营许可证","安全生产许可证",
                "化妆品卫生许可证","全国工业产品生产许可证","网络文化经营许可证","商品房预售许可证",
                "人才流动中介服务许可证","制造计量器具许可证","品流通许可证","出版物经营许可证",
                "收费许可证","开户许可证","营业性演出许可证","刻章许可证","特种设备制造许可证",
                "旅行社业务经营许可证","食品卫生许可证","药品经营许可证","印刷经营许可证",
                "电信与信息服务经营许可证","卫生许可证","烟花爆竹经营许可证",
                "电子认证服务许可证","医疗器械生产企业许可证","环境保护许可证","食品流通许可证","增值电信业务经营许可证"};
        adapter = new ChooseCategoryAdapter(this, R.layout.item_category_choose, category);
        categoryRvChoose.setLayoutManager(new LinearLayoutManager(this));
        categoryRvChoose.setNestedScrollingEnabled(false);
        categoryRvChoose.setAdapter(adapter);
    }

    @Override
    public void initView() {
        categoryTitle.setTitle("经营许可证类别");
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
                    .putExtra(ApplicationActivity.licente,category[position]);
            this.setResult(ApplicationActivity.LICENTE,intent);
            finish();
        });
    }

    @Override
    public void onClick(View v) {

    }
}
