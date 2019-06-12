package com.example.envelope.my.order.all;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.envelope.R;
import com.example.envelope.my.order.OrderAdapter;
import com.example.envelope.my.order.OrderBean;
import com.example.envelope.my.order.OrderDetailsActivity;
import com.example.envelope.utils.BaseFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 全部订单 fragment
 * Created by wangxian on 2019/6/12
 **/
public class AllOrderFragment extends BaseFragment {

    /**
     * 订单列表
     */
    @BindView(R.id.all_order_recycler)
    RecyclerView allOrderRecycler;
    private OrderAdapter adapter;
    private List<OrderBean> orderBeanList;

    /**
     * 刷新
     */
    @BindView(R.id.all_order_refreshLayout)
    SmartRefreshLayout allOrderRefreshLayout;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_all_order, null);
        unbinder = ButterKnife.bind(this, view);
        initData();
        initView();
        initEvent();
        return view;
    }

    @Override
    public void initData() {
        orderBeanList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            OrderBean orderBean = new OrderBean();
            orderBean.setMerchant("一家水果店" + i);
            orderBean.setMoneg("¥" + i*10);
            orderBean.setProduct("新鲜现切水果" + i);
            if (i > 4){
                orderBean.setState(i % 4);
            }else {
                orderBean.setState(i);
            }
            orderBean.setTime("2019-04-1" + i);
            orderBeanList.add(orderBean);
        }
        adapter = new OrderAdapter(getActivity(), R.layout.item_my_order, orderBeanList);
        allOrderRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        allOrderRecycler.setAdapter(adapter);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initEvent() {
        //订单详情
        adapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(getActivity(), OrderDetailsActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
