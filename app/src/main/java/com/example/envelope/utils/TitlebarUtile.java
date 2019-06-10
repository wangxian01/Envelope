package com.example.envelope.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.envelope.R;

/**
 * 标题栏封装
 * Created by wangxian on 2019/6/6
 **/
public class TitlebarUtile extends RelativeLayout {
    private LinearLayout layout_left, layout_right;
    private TextView tv_left, tv_title, tv_right;
    private ImageView iv_left, iv_right;
    private onViewClick mClick;

    public TitlebarUtile(Context context) {
        this(context, null);
    }

    public TitlebarUtile(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitlebarUtile(final Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.layout_title, this);
        initView();
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TitlebarView, defStyleAttr, 0);
        int count = array.getIndexCount();
        for (int i = 0; i < count; i++) {
            int attr = array.getIndex(i);
            switch (attr) {
                case R.styleable.TitlebarView_leftTextColor:
                    tv_left.setTextColor(array.getColor(attr, Color.BLACK));
                    break;
                case R.styleable.TitlebarView_leftDrawble:
                    iv_left.setImageResource(array.getResourceId(attr, 0));
                    break;
                case R.styleable.TitlebarView_leftText:
                    tv_left.setText(array.getString(attr));
                    break;
                case R.styleable.TitlebarView_centerTextColor:
                    tv_title.setTextColor(array.getColor(attr, Color.BLACK));
                    break;
                case R.styleable.TitlebarView_centerTitle:
                    tv_title.setText(array.getString(attr));
                    break;
                case R.styleable.TitlebarView_rightDrawable:
                    iv_right.setImageResource(array.getResourceId(attr, 0));
                    break;
                case R.styleable.TitlebarView_rightText:
                    tv_right.setText(array.getString(attr));
                    break;
                case R.styleable.TitlebarView_rightTextColor:
                    tv_right.setTextColor(array.getColor(attr, Color.BLACK));
                    break;
            }
        }
        array.recycle();
        layout_left.setOnClickListener(view -> mClick.leftClick());
        layout_right.setOnClickListener(view -> mClick.rightClick());

    }

    private void initView() {
        tv_left = findViewById(R.id.tv_left);
        tv_title = findViewById(R.id.tv_title);
        tv_right = findViewById(R.id.tv_right);
        iv_left = findViewById(R.id.iv_left);
        iv_right = findViewById(R.id.iv_right);
        layout_left = findViewById(R.id.layout_left);
        layout_right = findViewById(R.id.layout_right);

        //中间标题默认16ps
        tv_title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);

    }

    public void setOnViewClick(onViewClick click) {
        this.mClick = click;
    }

    //设置标题
    public void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            tv_title.setText(title);
        }
    }

    //设置左标题
    public void setLeftText(String title) {
        if (!TextUtils.isEmpty(title)) {
            tv_left.setText(title);
        }
    }

    //设置右标题
    public void setRightText(String title) {
        if (!TextUtils.isEmpty(title)) {
            tv_right.setText(title);
        }
    }

    //设置标题大小
    public void setTitleSize(int size) {
        if (tv_title != null) {
            tv_title.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        }
    }

    //设置左标题大小
    public void setLeftTextSize(int size) {
        if (tv_left != null) {
            tv_left.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        }
    }

    //设置右标题大小
    public void setRightTextSize(int size) {
        if (tv_right != null) {
            tv_right.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        }
    }

    //设置左图标
    public void setLeftDrawable(int res) {
        if (iv_left != null) {
            iv_left.setImageResource(res);
        }
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT);
//        layoutParams.setMargins(16,0,0,0);//4个参数按顺序分别是左上右下
//        iv_left.setLayoutParams(layoutParams);
    }

    //设置右图标
    public void setRightDrawable(int res) {
        if (iv_right != null) {
            iv_right.setImageResource(res);
        }
    }

    //设置右标题间距
    public void setRightMargins(int left,int top,int right,int bottom){
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(left,top,right,bottom);//4个参数按顺序分别是左上右下
        tv_right.setLayoutParams(layoutParams);
    }

    //设置左标题间距
    public void setLeftMargins(int left,int top,int right,int bottom){
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(left,top,right,bottom);//4个参数按顺序分别是左上右下
        tv_left.setLayoutParams(layoutParams);
    }

    public interface onViewClick {
        void leftClick();

        void rightClick();
    }

}

