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
 * 详情订单产品adapter
 * Created by wangxian on 2019/6/12
 **/
public class DetailsProdectAdapter extends BaseQuickAdapter<OrderBean, BaseViewHolder> {

    private Context context;

    public DetailsProdectAdapter(Context context, int layoutResId, @Nullable List<OrderBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderBean item) {

        helper.setText(R.id.item_details_tv_name,item.getMerchant());
        helper.setText(R.id.item_details_tv_specification,item.getProduct());
        helper.setText(R.id.item_order_tv_product_money,item.getMoneg());

    }


}

