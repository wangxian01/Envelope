package com.example.envelope.my.information;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.envelope.R;
import com.example.envelope.my.information.addresses.AddressesActivity;
import com.example.envelope.my.information.nickname.NickNameActivity;
import com.example.envelope.my.information.signature.SinatureActivity;
import com.example.envelope.utils.BaseActivity;
import com.example.envelope.utils.CircleImageView;
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
 * 我的信息
 * Created by wangxian on 2019/6/6
 **/
public class MyInformationActivity extends BaseActivity {

    /**
     * 封装好的标题栏
     */
    @BindView(R.id.imformation_title)
    TitlebarUtile imformationTitle;

    /**
     * 头像
     */
    @BindView(R.id.aty_information_img_head)
    CircleImageView atyInformationImgHead;
    @BindView(R.id.aty_information_rl_head)
    RelativeLayout atyInformationRlHead;

    /**
     * 昵称
     */
    @BindView(R.id.aty_information_tv_name)
    TextView atyInformationTvName;
    @BindView(R.id.aty_information_rl_name)
    RelativeLayout atyInformationRlName;

    /**
     * 签名
     */
    @BindView(R.id.aty_information_tv_signature)
    TextView atyInformationTvSignature;
    @BindView(R.id.aty_information_rl_signature)
    RelativeLayout atyInformationRlSignature;

    /**
     * 地址
     */
    @BindView(R.id.aty_information_rl_addresses)
    RelativeLayout atyInformationRlAddresses;

    private List<LocalMedia> list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_my_information);
        ButterKnife.bind(this);
        initData();
        initView();
        initEvent();
    }

    @Override
    public void initData() {
        list = new ArrayList<>();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initEvent() {
        atyInformationRlAddresses.setOnClickListener(this);
        atyInformationRlHead.setOnClickListener(this);
        atyInformationRlName.setOnClickListener(this);
        atyInformationRlSignature.setOnClickListener(this);
        imformationTitle.setOnViewClick(new TitlebarUtile.onViewClick() {
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
            //修改头像
            case R.id.aty_information_rl_head:
                choosePhoto();
                break;
            //修改昵称
            case R.id.aty_information_rl_name:
                Intent intentNick = new Intent(MyInformationActivity.this, NickNameActivity.class)
                        .putExtra("name",atyInformationTvName.getText().toString());
                startActivity(intentNick);
                break;
            //修改签名
            case R.id.aty_information_rl_signature:
                Intent intentSinature = new Intent(MyInformationActivity.this, SinatureActivity.class)
                        .putExtra("signature",atyInformationTvSignature.getText().toString());
                startActivity(intentSinature);
                break;
            //修改地址
            case R.id.aty_information_rl_addresses:
                Intent intentAddresses = new Intent(MyInformationActivity.this, AddressesActivity.class);
                startActivity(intentAddresses);
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

                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                            .imageSpanCount(4)// 每行显示个数 int
                            .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                            .previewImage(true)// 是否可预览图片 true or false
                            .isCamera(true)// 是否显示拍照按钮 true or false
                            .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                            .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                            .enableCrop(true)// 是否裁剪 true or false
                            .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                            .circleDimmedLayer(true)// 是否圆形裁剪 true or false
                            .selectionMedia(list)// 是否传入已选图片 List<LocalMedia> list
                            .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                            .previewEggs(true)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
                            .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code

                })
                .onDenied(permissions -> {
                    // Storage permission are not allowed.
                    ToastUtil.showShort(this, "权限未申请成功!");
                })
                .start();
    }

    @SuppressLint("CheckResult")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PictureConfig.CHOOSE_REQUEST && resultCode == RESULT_OK) {
            if (data != null) {
                //图片单选和多选数据都是以ArrayList的字符串数组返回的。
                // 图片、视频、音频选择结果回调
                List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                // 例如 LocalMedia 里面返回三种path
                // 1.media.getPath(); 为原图path
                // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true  注意：音视频除外
                // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true  注意：音视频除外
                // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的

                if (list.size() != 0){
                    list.clear();
                }

                for (int i = 0; i < selectList.size(); i++) {
                    list.add(selectList.get(0));
                }
                if (list.get(0).isCut() == true){
                    Glide.with(this).load(list.get(0).getCutPath()).into(atyInformationImgHead);
                }else {
                    Glide.with(this).load(list.get(0).getPath()).into(atyInformationImgHead);
                }

            }


        }
    }
}
