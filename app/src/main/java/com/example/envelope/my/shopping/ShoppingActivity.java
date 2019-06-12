package com.example.envelope.my.shopping;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.envelope.R;
import com.example.envelope.my.order.DetailsProdectAdapter;
import com.example.envelope.my.order.OrderBean;
import com.example.envelope.utils.BaseActivity;
import com.example.envelope.utils.TitlebarUtile;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 购物车页面
 * Created by wangxian on 2019/6/12
 **/
public class ShoppingActivity extends BaseActivity {

    /**
     * 标题栏
     */
    @BindView(R.id.shopping_title)
    TitlebarUtile shoppingTitle;

    /**
     * 店铺列表
     */
    @BindView(R.id.shopping_car_recycler)
    RecyclerView shoppingCarRecycler;
    private ShoppingMerchantAdapter adapter;
    // TODO: 2019/6/12 暂用ShoppingBean装数据
    private List<ShoppingBean> shoppingBeans;

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
        shoppingBeans = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            ShoppingBean shoppingBean = new ShoppingBean();
            shoppingBeans.add(shoppingBean);
        }
        adapter = new ShoppingMerchantAdapter(this, R.layout.item_shopping_car_merchant, shoppingBeans);
        shoppingCarRecycler.setLayoutManager(new LinearLayoutManager(this));
        shoppingCarRecycler.setNestedScrollingEnabled(false);
        shoppingCarRecycler.setAdapter(adapter);
    }

    @Override
    public void initView() {

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
