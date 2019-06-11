package com.example.envelope.publish;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.envelope.R;
import com.example.envelope.utils.LittieUtil;

import java.util.List;

/**
 * 图片选择适配器
 * Created by wangxian on 2019/6/5
 **/
public class ChoosePictureAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    private Context context;
    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public ChoosePictureAdapter(Context context, int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        if (helper.getAdapterPosition() == 0) {
            helper.getView(R.id.item_picture_delete).setVisibility(View.INVISIBLE);
            Glide.with(context).load(R.mipmap.ic_choose_picture).into((ImageView) helper.getView(R.id.item_picture_choose));
        } else {
            Glide.with(context).load(item).into((ImageView) helper.getView(R.id.item_picture_choose));
        }
        helper.getView(R.id.item_picture_choose).setOnClickListener(view -> {
            if (helper.getAdapterPosition() == 0 && itemClickListener != null) {
                itemClickListener.takePhoto();
            }
        });
        helper.getView(R.id.item_picture_delete).setOnClickListener(view -> {
            if (helper.getAdapterPosition() != 0 && itemClickListener != null) {
                itemClickListener.delete(helper.getAdapterPosition());
            }
        });
    }

    public interface ItemClickListener {
        /**
         * 选择照片点击
         */
        void takePhoto();

        /**
         * 删除图片点击
         */
        void delete(int position);
    }

}
