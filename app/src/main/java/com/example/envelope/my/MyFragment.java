package com.example.envelope.my;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.envelope.R;
import com.example.envelope.my.application.ApplicationActivity;
import com.example.envelope.my.collect.MyCollectActivity;
import com.example.envelope.my.information.MyInformationActivity;
import com.example.envelope.my.massage.MyMessageActivity;
import com.example.envelope.my.mypublish.MyPublishActivity;
import com.example.envelope.my.order.OrderActivity;
import com.example.envelope.my.redpacket.RedPacketActivity;
import com.example.envelope.my.setting.SettingActivity;
import com.example.envelope.my.shopping.ShoppingActivity;
import com.example.envelope.my.wallet.MyWalletActivity;
import com.example.envelope.utils.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 我的 fragment
 * Created by wangxian on 2019/6/5
 **/
public class MyFragment extends Fragment implements View.OnClickListener {

    /**
     * 消息图标
     */
    @BindView(R.id.my_img_massage)
    ImageView myImgMassage;

    /**
     * 设置
     */
    @BindView(R.id.my_img_setting)
    ImageView myImgSetting;

    /**
     * 个人信息
     */
    @BindView(R.id.my_rl_information)
    RelativeLayout myRlInformation;

    /**
     * 我的名称
     */
    @BindView(R.id.my_tv_name)
    TextView myTvName;

    /**
     * 我的签名
     */
    @BindView(R.id.my_tv_signature)
    TextView myTvSignature;

    /**
     * 商家申请
     */
    @BindView(R.id.my_tv_business_application)
    TextView myTvBusinessApplication;

    /**
     * 我的钱包
     */
    @BindView(R.id.my_rl_wallet)
    RelativeLayout myRlWallet;

    /**
     * 我的订单
     */
    @BindView(R.id.my_rl_order)
    RelativeLayout myRlOrder;

    /**
     * 购物数量
     */
    @BindView(R.id.my_tv_shopping_cart)
    TextView myTvShoppingCart;

    /**
     * 我的购物车
     */
    @BindView(R.id.my_rl_shopping)
    RelativeLayout myRlShopping;

    /**
     * 我的发布
     */
    @BindView(R.id.my_rl_publish)
    RelativeLayout myRlPublish;

    /**
     * 抢到的红包
     */
    @BindView(R.id.my_rl_red_packet)
    RelativeLayout myRlRedPacket;

    /**
     * 我的收藏
     */
    @BindView(R.id.my_rl_collect)
    RelativeLayout myRlCollect;

    /**
     * 我的店铺
     */
    @BindView(R.id.my_rl_store)
    RelativeLayout myRlStore;

    /**
     * 分享
     */
    @BindView(R.id.my_rl_share)
    RelativeLayout myRlShare;

    /**
     * 意见反馈
     */
    @BindView(R.id.my_rl_feedback)
    RelativeLayout myRlFeedback;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_my, null);
        unbinder = ButterKnife.bind(this, view);
        initEvent();
        return view;
    }

    /**
     * 事件
     */
    private void initEvent() {
        myRlInformation.setOnClickListener(this);
        myImgMassage.setOnClickListener(this);
        myImgSetting.setOnClickListener(this);
        myRlCollect.setOnClickListener(this);
        myRlFeedback.setOnClickListener(this);
        myRlOrder.setOnClickListener(this);
        myRlPublish.setOnClickListener(this);
        myRlRedPacket.setOnClickListener(this);
        myRlShare.setOnClickListener(this);
        myRlShopping.setOnClickListener(this);
        myRlStore.setOnClickListener(this);
        myRlWallet.setOnClickListener(this);
        myTvBusinessApplication.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //消息
            case R.id.my_img_massage:
                Intent intentMyMessage = new Intent(getActivity(), MyMessageActivity.class);
                startActivity(intentMyMessage);
                break;
            //设置
            case R.id.my_img_setting:
                Intent intentSetting = new Intent(getActivity(), SettingActivity.class);
                startActivity(intentSetting);
                break;
            //个人信息
            case R.id.my_rl_information:
                Intent intentMyInformation = new Intent(getActivity(), MyInformationActivity.class);
                startActivity(intentMyInformation);
                break;
            //申请成为商家
            case R.id.my_tv_business_application:
                Intent intentApplication = new Intent(getActivity(), ApplicationActivity.class);
                startActivity(intentApplication);
                break;
            //钱包
            case R.id.my_rl_wallet:
                Intent intentWallet = new Intent(getActivity(), MyWalletActivity.class);
                startActivity(intentWallet);
                break;
            //订单
            case R.id.my_rl_order:
                Intent intentOrder = new Intent(getActivity(), OrderActivity.class);
                startActivity(intentOrder);
                break;
            //我的购物车
            case R.id.my_rl_shopping:
                Intent intentShopping = new Intent(getActivity(), ShoppingActivity.class);
                startActivity(intentShopping);
                break;
            //发布
            case R.id.my_rl_publish:
                Intent intentMyPublish = new Intent(getActivity(), MyPublishActivity.class);
                startActivity(intentMyPublish);
                break;
            //红包
            case R.id.my_rl_red_packet:
                Intent intentRedPacket = new Intent(getActivity(), RedPacketActivity.class);
                startActivity(intentRedPacket);
                break;
            //收藏
            case R.id.my_rl_collect:
                Intent intentMyCollect = new Intent(getActivity(), MyCollectActivity.class);
                startActivity(intentMyCollect);
                break;
            //店铺
            case R.id.my_rl_store:
                break;
            //分享
            case R.id.my_rl_share:
                break;
            //意见
            case R.id.my_rl_feedback:
                break;
        }
    }
}
