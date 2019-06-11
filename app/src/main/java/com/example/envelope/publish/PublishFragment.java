package com.example.envelope.publish;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.envelope.R;
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
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;

/**
 * 发布fragment
 * Created by wangxian on 2019/6/5
 **/
public class PublishFragment extends Fragment {

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
                choosePhoto();
            }

            @Override
            public void delete(int position) {
                images.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * 选择图片
     */
    private void choosePhoto() {
        //权限申请
        AndPermission.with(getActivity())
                .runtime()
                .permission(Permission.Group.STORAGE,
                        Permission.Group.CAMERA)
                .onGranted(permissions -> {
                    int maxCount = 10 - images.size();
                    if (maxCount > 0) {
                        PictureSelector.create(PublishFragment.this)
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
                        ToastUtil.showShort(getActivity(),"只能上传九张");
                    }
                })
                .onDenied(permissions -> {
                    // Storage permission are not allowed.
                    ToastUtil.showShort(getActivity(), "权限未申请成功!");
                })
                .start();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
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
                for (int i = 0; i < selectList.size(); i++) {
                    images.add(selectList.get(i).getPath());
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
