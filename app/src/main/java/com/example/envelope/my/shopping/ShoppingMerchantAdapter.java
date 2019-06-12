package com.example.envelope.my.shopping;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.envelope.R;

import java.util.List;

/**
 * 购物车adapter
 * Created by wangxian on 2019/6/12
 **/
public class ShoppingMerchantAdapter extends BaseQuickAdapter<ShoppingBean, BaseViewHolder> {

    private Context context;

    public ShoppingMerchantAdapter(Context context, int layoutResId, @Nullable List<ShoppingBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ShoppingBean item) {

        RecyclerView recyclerView = helper.getView(R.id.shopping_car_merchant_recycler);

    }


}

