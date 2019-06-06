package com.example.envelope.activities;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.envelope.R;

import java.util.List;

public class ActivitesAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    private Context context;

    public ActivitesAdapter(Context context,int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
//        Glide.with(context).load(R.mipmap.img_activites0).into((ImageView) helper.getView(R.id.item_activites_img_content));
    }


}
