package com.example.envelope.my.order;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.envelope.R;

import java.util.List;

/**
 * 订单adapter
 * Created by wangxian on 2019/6/12
 **/
public class OrderAdapter extends BaseQuickAdapter<OrderBean, BaseViewHolder> {

    private Context context;

    public OrderAdapter(Context context, int layoutResId, @Nullable List<OrderBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderBean item) {

        helper.setText(R.id.item_order_tv_merchant_name,item.getMerchant());
        helper.setText(R.id.item_order_tv_product_money,item.getMoneg());
        helper.setText(R.id.item_order_tv_product_name,item.getProduct());
        helper.setText(R.id.item_order_tv_time,item.getTime());
        TextView stateLeft = helper.getView(R.id.item_order_tv_state_left);
        TextView stateRight = helper.getView(R.id.item_order_tv_state_right);
        switch (item.getState()){
            //待支付
            case 0:
                stateLeft.setText("取消订单");
                stateRight.setText("待支付");
                break;
            //待发货
            case 1:
                stateLeft.setVisibility(View.INVISIBLE);
                stateRight.setText("待发货");
                break;
            //待收货
            case 2:
                stateLeft.setVisibility(View.INVISIBLE);
                stateRight.setText("待收货");
                break;
            //退款
            case 3:
                stateLeft.setText("删除订单");
                stateRight.setText("退款");
                break;
            default:break;
        }

    }


}

