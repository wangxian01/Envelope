package com.example.envelope.fenglu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.envelope.R;
import com.example.envelope.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 奉鹿fragment
 * Created by wangxian on 2019/6/4
 **/
public class FengluFragment extends Fragment {

    /**
     * 搜索框
     */
    @BindView(R.id.fenglu_et_search)
    EditText fengluEtSearch;

    /**
     * 筛选
     */
    @BindView(R.id.fenglu_tv_filtrate)
    TextView fengluTvFiltrate;

    /**
     * 轮播图
     */
    @BindView(R.id.fenglu_banner)
    Banner fengluBanner;
    Unbinder unbinder;

    private ArrayList<Integer> images;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_fenglu, null);

        unbinder = ButterKnife.bind(this, view);

        initData();
        initView();

        return view;
    }

    /**
     * 初始化数据
     */
    private void initData() {
        // TODO: 2019/6/4 轮播图暂用项目图片
        images = new ArrayList<>();
        images.add(R.mipmap.banner01);
        images.add(R.mipmap.banner02);
        images.add(R.mipmap.banner01);
    }

    /**
     * 初始化控件
     */
    private void initView() {

        // TODO: 2019/6/5 地图模块暂时未加 

        //设置banner样式
        fengluBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                    .setIndicatorGravity(BannerConfig.CENTER)//显示器居中
                    .setImageLoader(new GlideImageLoader()) //设置图片加载器
                    .setImages(images)//设置图片集合
                    .setBannerAnimation(Transformer.DepthPage)//设置banner动画效果
                    .isAutoPlay(true)//设置自动轮播，默认为true
                    .setDelayTime(3000)//设置轮播时间
                    .start();//banner设置方法全部调用完毕时最后调用

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        fengluBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (fengluBanner != null){
            //结束轮播
            fengluBanner.stopAutoPlay();
        }

    }
}
