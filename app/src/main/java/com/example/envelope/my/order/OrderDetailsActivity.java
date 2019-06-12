package com.example.envelope.my.order;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.envelope.R;
import com.example.envelope.utils.BaseActivity;
import com.example.envelope.utils.CircleImageView;
import com.example.envelope.utils.TitlebarUtile;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 订单详情
 * Created by wangxian on 2019/6/12
 **/
public class OrderDetailsActivity extends BaseActivity {

    /**
     * 标题栏
     */
    @BindView(R.id.order_details_title)
    TitlebarUtile orderDetailsTitle;

    /**
     * 用户名
     */
    @BindView(R.id.order_details_tv_username)
    TextView orderDetailsTvUsername;

    /**
     * 联系电话
     */
    @BindView(R.id.order_details_tv_phone)
    TextView orderDetailsTvPhone;

    /**
     * 地址
     */
    @BindView(R.id.order_details_tv_address)
    TextView orderDetailsTvAddress;

    /**
     * 商家头像
     */
    @BindView(R.id.order_details_img_merchant_hand)
    CircleImageView orderDetailsImgMerchantHand;

    /**
     * 商家名称
     */
    @BindView(R.id.order_details_tv_merchant_name)
    TextView orderDetailsTvMerchantName;

    /**
     * 产品列表
     */
    @BindView(R.id.order_details_recycler)
    RecyclerView orderDetailsRecycler;

    /**
     * 配送方法
     */
    @BindView(R.id.order_details_tv_method)
    TextView orderDetailsTvMethod;

    /**
     * 二维码图片
     */
    @BindView(R.id.order_details_img_verification_code)
    ImageView orderDetailsImgVerificationCode;

    /**
     * 订单号
     */
    @BindView(R.id.order_details_tv_number)
    TextView orderDetailsTvNumber;
    private DetailsProdectAdapter adapter;
    // TODO: 2019/6/12 暂用orderbean装数据
    private List<OrderBean> orderBeanList;

    /**
     * 订单时间
     */
    @BindView(R.id.order_details_tv_time)
    TextView orderDetailsTvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_order_details);
        ButterKnife.bind(this);
        initData();
        initView();
        initEvent();
    }

    @Override
    public void initData() {
        orderBeanList = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            OrderBean orderBean = new OrderBean();
            orderBean.setMerchant("新鲜现切水果" + i);
            orderBean.setMoneg("¥" + i*10);
            orderBean.setProduct("300" + i +"g");
            orderBeanList.add(orderBean);
        }
        adapter = new DetailsProdectAdapter(this, R.layout.item_order_details_prodect, orderBeanList);
        orderDetailsRecycler.setLayoutManager(new LinearLayoutManager(this));
        orderDetailsRecycler.setNestedScrollingEnabled(false);
        orderDetailsRecycler.setAdapter(adapter);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initEvent() {
        orderDetailsTitle.setOnViewClick(new TitlebarUtile.onViewClick() {
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
