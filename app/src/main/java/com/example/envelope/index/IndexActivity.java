package com.example.envelope.index;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.envelope.R;
import com.example.envelope.activities.ActivitesFragment;
import com.example.envelope.fenglu.FengluFragment;
import com.example.envelope.my.MyFragment;
import com.example.envelope.publish.PublishFragment;
import com.next.easynavigation.view.EasyNavigationBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 主页面
 * Created by wangxian on 2019/6/4
 **/
public class IndexActivity extends AppCompatActivity {

    @BindView(R.id.index_navigationBar)
    EasyNavigationBar indexNavigationBar;

    private String[] tabText = {"奉鹿", "发布", "活动", "我的"};
    //未选中icon
    private int[] normalIcon = {R.mipmap.fenglu2, R.mipmap.fabu2, R.mipmap.navactivity2, R.mipmap.wode2};
    //选中时icon
    private int[] selectIcon = {R.mipmap.fenglu, R.mipmap.fabu, R.mipmap.navactivity, R.mipmap.wode};
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_index);
        ButterKnife.bind(this);
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView(){
        fragments.add(new FengluFragment());
        fragments.add(new PublishFragment());
        fragments.add(new ActivitesFragment());
        fragments.add(new MyFragment());

        indexNavigationBar.titleItems(tabText)
                .normalIconItems(normalIcon)
                .selectIconItems(selectIcon)
                .fragmentList(fragments)
                .fragmentManager(getSupportFragmentManager())
                .canScroll(false)    //Viewpager能否左右滑动
                .selectTextColor(Color.parseColor("#EB562E"))   //Tab选中时字体颜色
                .navigationHeight(60)  //导航栏高度
                .build();
    }
}
