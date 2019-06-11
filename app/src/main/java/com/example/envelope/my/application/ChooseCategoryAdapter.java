package com.example.envelope.my.application;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.envelope.R;

import java.util.Arrays;
import java.util.List;

/**
 * 商家类型选择适配器
 * Created by wangxian on 2019/6/5
 **/
public class ChooseCategoryAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    private Context context;

    public ChooseCategoryAdapter(Context context, int layoutResId, @Nullable String[] data) {
        super(layoutResId, Arrays.asList(data));
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.item_category_tv,item);
    }


}
