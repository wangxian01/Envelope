package com.example.envelope.my.order;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.envelope.R;
import com.example.envelope.my.order.all.AllOrderFragment;
import com.example.envelope.my.order.obligation.ObligationFragment;
import com.example.envelope.my.order.refund.RefundFragment;
import com.example.envelope.my.order.sendgoods.SendGoodsFragment;
import com.example.envelope.my.order.waitreceiving.WaitReceivingFragment;
import com.example.envelope.utils.BaseActivity;
import com.example.envelope.utils.TitlebarUtile;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 我的订单
 * Created by wangxian on 2019/6/6
 **/
public class OrderActivity extends BaseActivity {

    /**
     * viewpager指示器
     */
    @BindView(R.id.order_magic_indicator)
    MagicIndicator orderMagicIndicator;

    /**
     * 订单viewpager
     */
    @BindView(R.id.order_view_pager)
    ViewPager orderViewPager;

    /**
     * 标题栏
     */
    @BindView(R.id.order_title)
    TitlebarUtile orderTitle;

    private CommonNavigator commonNavigator;
    private String title[];
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_order);
        ButterKnife.bind(this);

        initData();
        initView();
        initEvent();
    }

    @Override
    public void initData() {
        title = new String[]{"全部", "代付款", "代发货", "待收货", "退款"};
    }

    @Override
    public void initView() {
        orderTitle.setTitleSize(16);
        myAdapter = new MyAdapter(getSupportFragmentManager());
        orderViewPager.setAdapter(myAdapter);
        commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return title == null ? 0 : title.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, int index) {
                ClipPagerTitleView clipPagerTitleView = new ClipPagerTitleView(context);

                clipPagerTitleView.setText(title[index]);
                clipPagerTitleView.setTextColor(Color.BLACK);
                clipPagerTitleView.setClipColor(Color.BLACK);

                clipPagerTitleView.setOnClickListener(v -> orderViewPager.setCurrentItem(index));

                return clipPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setColors(Color.parseColor("#EB562E"));
                return indicator;
            }
        });
        commonNavigator.setAdjustMode(true);
        orderMagicIndicator.setNavigator(commonNavigator);

        orderViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                orderMagicIndicator.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                orderMagicIndicator.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                orderMagicIndicator.onPageScrollStateChanged(state);
            }
        });

        orderViewPager.setCurrentItem(0);
    }

    @Override
    public void initEvent() {
        orderTitle.setOnViewClick(new TitlebarUtile.onViewClick() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {

            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    private class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                //全部
                case 0:
                    AllOrderFragment allOrderFragment = new AllOrderFragment();
                    fragment = allOrderFragment;
                    break;
                //待支付
                case 1:
                    ObligationFragment obligationFragment = new ObligationFragment();
                    fragment = obligationFragment;
                    break;
                //待发货
                case 2:
                    SendGoodsFragment sendGoodsFragment = new SendGoodsFragment();
                    fragment = sendGoodsFragment;
                    break;
                //待接收
                case 3:
                    WaitReceivingFragment waitReceivingFragment = new WaitReceivingFragment();
                    fragment = waitReceivingFragment;
                    break;
                //退款
                case 4:
                    RefundFragment refundFragment = new RefundFragment();
                    fragment = refundFragment;
                    break;
                default:
                    break;
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }


    }


}
