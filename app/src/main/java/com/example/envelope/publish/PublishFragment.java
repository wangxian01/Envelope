package com.example.envelope.publish;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.envelope.R;
import com.example.envelope.utils.GlideEngineUtil;
import com.example.envelope.utils.ToastUtil;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.filter.Filter;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;

/**
 * 发布fragment
 * Created by wangxian on 2019/6/5
 **/
public class PublishFragment extends Fragment {

    private static final int REQUEST_CODE_CHOOSE = 1001;

    /**
     * 发布内容
     */
    @BindView(R.id.publish_et_content)
    EditText publishEtContent;

    /**
     * 图片recycviewview
     */
    @BindView(R.id.publish_picture_recycler)
    RecyclerView publishPictureRecycler;
    private ChoosePictureAdapter adapter;
    private List<String> images;

    /**
     * 位置文字
     */
    @BindView(R.id.publish_tv_location)
    TextView publishTvLocation;

    /**
     * 位置按钮
     */
    @BindView(R.id.publish_choose_location)
    ImageView publishChooseLocation;

    /**
     * 红包金额
     */
    @BindView(R.id.publish_et_money)
    EditText publishEtMoney;

    /**
     * 红包数量
     */
    @BindView(R.id.publish_et_number)
    EditText publishEtNumber;

    /**
     * 发布按钮
     */
    @BindView(R.id.publish_tv_sure)
    TextView publishTvSure;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_publish, null);
        unbinder = ButterKnife.bind(this, view);
        initData();
        initView();
        initEvent();

        return view;
    }


    /**
     * 数据
     */
    private void initData() {
        images = new ArrayList<>();
        images.add("header");
        adapter = new ChoosePictureAdapter(getActivity(), R.layout.item_choose_picture, images);
        publishPictureRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        publishPictureRecycler.setNestedScrollingEnabled(false);
        publishPictureRecycler.setAdapter(adapter);
    }

    /**
     * 控件
     */
    private void initView() {

    }

    /**
     * 事件
     */
    private void initEvent() {
        adapter.setItemClickListener(new ChoosePictureAdapter.ItemClickListener() {
            @Override
            public void takePhoto() {
                //权限申请
                AndPermission.with(getActivity())
                        .runtime()
                        .permission(Permission.Group.STORAGE,
                                Permission.Group.CAMERA)
                        .onGranted(permissions -> {
                            // Storage permission are allowed.
                            int maxCount = 10 - images.size();
                            if (maxCount > 0) {
                                Matisse.from(PublishFragment.this)
                                        .choose(MimeType.allOf())//图片类型
                                        .countable(true)//true:选中后显示数字;false:选中后显示对号
                                        .maxSelectable(5)//可选的最大数
                                        .capture(true)//选择照片时，是否显示拍照
                                        .theme(R.style.Matisse_Dracula)
                                        .captureStrategy(new CaptureStrategy(true, "com.example.envelope.fileprovider"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                                        .imageEngine(new GlideEngineUtil())//图片加载引擎
                                        .forResult(REQUEST_CODE_CHOOSE);
                            } else {

                            }
                        })
                        .onDenied(permissions -> {
                            // Storage permission are not allowed.
                            ToastUtil.showShort(getActivity(), "权限未申请成功!");
                        })
                        .start();
            }
            @Override
            public void delete(int position) {
                images.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            if (data != null){
                List<Uri> result = Matisse.obtainResult(data);
                for (int i = 0; i < result.size(); i++) {
                    images.add(result.get(i).toString());
                }
                adapter.notifyDataSetChanged();
            }


        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
