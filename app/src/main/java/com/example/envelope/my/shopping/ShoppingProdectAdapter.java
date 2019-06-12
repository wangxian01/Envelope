package com.example.envelope.my.shopping;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 购物车adapter
 * Created by wangxian on 2019/6/12
 **/
public class ShoppingProdectAdapter extends BaseQuickAdapter<ShoppingBean, BaseViewHolder> {

    private Context context;

    public ShoppingProdectAdapter(Context context, int layoutResId, @Nullable List<ShoppingBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ShoppingBean item) {


    }


}

