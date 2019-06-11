package com.example.envelope.my.application;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.envelope.R;
import com.example.envelope.publish.ChoosePictureAdapter;
import com.example.envelope.utils.BaseActivity;
import com.example.envelope.utils.TitlebarUtile;
import com.example.envelope.utils.ToastUtil;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 商家申请
 * Created by wangxian on 2019/6/11
 **/
public class ApplicationActivity extends BaseActivity {

    /**
     * 标题栏
     */
    @BindView(R.id.application_title)
    TitlebarUtile applicationTitle;

    /**
     * 商家名称
     */
    @BindView(R.id.application_et_merchant_name)
    EditText applicationEtMerchantName;

    /**
     * 商家类别名称
     */
    @BindView(R.id.application_tv_merchant_category)
    TextView applicationTvMerchantCategory;
    @BindView(R.id.application_rl_merchant_category)
    RelativeLayout applicationRlMerchantCategory;

    /**
     * 选择图片
     */
    @BindView(R.id.application_rv_choose_picture)
    RecyclerView applicationRvChoosePicture;
    private ChoosePictureAdapter adapter;
    private List<String> images;

    /**
     * 经营许可证
     */
    @BindView(R.id.application_tv_licence)
    TextView applicationTvLicence;
    @BindView(R.id.application_rl_licence)
    RelativeLayout applicationRlLicence;

    /**
     * 联系方式
     */
    @BindView(R.id.application_et_contact)
    EditText applicationEtContact;

    /**
     * 提交按钮
     */
    @BindView(R.id.application_tv_submit)
    TextView applicationTvSubmit;

    public static final int MERCHANT_CATEGORY = 10208;
    public static final String merchant = "category";
    public static final int LICENTE = 10209;
    public static final String licente = "licente";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_application);
        ButterKnife.bind(this);
        initData();
        initView();
        initEvent();
    }

    @Override
    public void initData() {
        images = new ArrayList<>();
        images.add("header");
        adapter = new ChoosePictureAdapter(this, R.layout.item_choose_picture, images);
        applicationRvChoosePicture.setLayoutManager(new GridLayoutManager(this, 4));
        applicationRvChoosePicture.setNestedScrollingEnabled(false);
        applicationRvChoosePicture.setAdapter(adapter);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initEvent() {
        applicationRlMerchantCategory.setOnClickListener(this);
        applicationRlLicence.setOnClickListener(this);
        applicationTvSubmit.setOnClickListener(this);
        adapter.setItemClickListener(new ChoosePictureAdapter.ItemClickListener() {
            @Override
            public void takePhoto() {
                choosePhoto();
            }

            @Override
            public void delete(int position) {
                images.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        applicationTitle.setOnViewClick(new TitlebarUtile.onViewClick() {
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
        switch (v.getId()) {
            case R.id.application_rl_merchant_category:
                Intent intentCategory = new Intent(this, CategoryActivity.class);
                startActivityForResult(intentCategory, MERCHANT_CATEGORY);
                break;
            case R.id.application_rl_licence:
                Intent intentLicence = new Intent(this, LicenceActivity.class);
                startActivityForResult(intentLicence, LICENTE);
                break;
            case R.id.application_tv_submit:
                break;
        }
    }

    /**
     * 选择图片
     */
    private void choosePhoto() {
        //权限申请
        AndPermission.with(this)
                .runtime()
                .permission(Permission.Group.STORAGE,
                        Permission.Group.CAMERA)
                .onGranted(permissions -> {
                    int maxCount = 10 - images.size();
                    if (maxCount > 0) {
                        PictureSelector.create(this)
                                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                                .maxSelectNum(maxCount)// 最大图片选择数量 int
                                .imageSpanCount(4)// 每行显示个数 int
                                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                                .previewImage(true)// 是否可预览图片 true or false
                                .isCamera(true)// 是否显示拍照按钮 true or false
                                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                                .previewEggs(true)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
                                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
                    } else {
                        ToastUtil.showShort(this, "只能上传九张");
                    }
                })
                .onDenied(permissions -> {
                    // Storage permission are not allowed.
                    ToastUtil.showShort(this, "权限未申请成功!");
                })
                .start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == PictureConfig.CHOOSE_REQUEST) {
            if (data != null) {
                List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                for (int i = 0; i < selectList.size(); i++) {
                    images.add(selectList.get(i).getPath());
                }
                adapter.notifyDataSetChanged();
            }
        }

        switch (requestCode) {
            case MERCHANT_CATEGORY:
                if (data != null) {
                    applicationTvMerchantCategory.setText(data.getStringExtra(merchant));
                }
                break;
            case LICENTE:
                if (data != null) {
                    applicationTvLicence.setText(data.getStringExtra(licente));
                }
                break;
            default:
                break;
        }
    }
}
