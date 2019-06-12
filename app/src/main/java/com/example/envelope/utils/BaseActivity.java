package com.example.envelope.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.envelope.R;
import com.gyf.immersionbar.ImmersionBar;

import butterknife.ButterKnife;

/**
 * 通用activity封装
 * Created by wangxian on 2019/6/10
 **/
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    protected final String TAG = "fenglu -->>>" + this.getClass().getSimpleName();
    protected ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myLog("-->onCreate()");
        initImmersionBar();
    }

    /**
     * 初始化沉浸式
     */
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarColor(R.color.orange)
                     .fitsSystemWindows(true)  //使用该属性必须指定状态栏的颜色，不然状态栏透明，很难看
                     .init();
    }

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

    @Override
    protected void onStart() {
        super.onStart();
        myLog("--->onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        myLog("--->onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        myLog( "--->onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        myLog( "--->onStop()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if (mImmersionBar != null) {
//            mImmersionBar.destroy();
//        }
        myLog("--->onDestroy()");
    }

    /**
     * 日志输出
     *
     * @param msg
     */
    protected void myLog(String msg) {
        Log.e(TAG, msg );
    }

}
