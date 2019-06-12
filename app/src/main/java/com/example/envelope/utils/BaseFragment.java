package com.example.envelope.utils;

import android.support.v4.app.Fragment;
import android.view.View;

/**
 * 简单Fragment封装
 * Created by wangxian on 2019/6/12
 **/
public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 初始化布局
     */
    public abstract void initView();

    /**
     * 初始化事件
     */
    public abstract void initEvent();



}
