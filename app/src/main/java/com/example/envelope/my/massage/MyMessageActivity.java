package com.example.envelope.my.massage;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.envelope.R;
import com.example.envelope.utils.BaseActivity;
import com.example.envelope.utils.TitlebarUtile;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 我的消息
 * Created by wangxian on 2019/6/11
 **/
public class MyMessageActivity extends BaseActivity {

    /**
     * 标题栏
     */
    @BindView(R.id.aty_my_message_title)
    TitlebarUtile atyMyMessageTitle;

    /**
     * 系统消息时间
     */
    @BindView(R.id.message_tv_system_time)
    TextView messageTvSystemTime;

    /**
     * 系统消息数量
     */
    @BindView(R.id.message_tv_system_number)
    TextView messageTvSystemNumber;

    /**
     * 系统消息
     */
    @BindView(R.id.my_message_cl_system)
    ConstraintLayout myMessageClSystem;

    /**
     * 评论
     */
    @BindView(R.id.my_message_rl_comment)
    RelativeLayout myMessageRlComment;

    /**
     * 赞
     */
    @BindView(R.id.my_message_rl_like)
    RelativeLayout myMessageRlLike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_my_message);
        ButterKnife.bind(this);
        initData();
        initView();
        initEvent();
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initEvent() {
        atyMyMessageTitle.setOnViewClick(new TitlebarUtile.onViewClick() {
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
        switch (v.getId()){

        }
    }
}
