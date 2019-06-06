package com.example.envelope.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.envelope.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 活动fragment
 * Created by wangxian on 2019/6/5
 **/
public class ActivitesFragment extends Fragment {

    /**
     * 消息数量
     */
    @BindView(R.id.activites_tv_number)
    TextView activitesTvNumber;

    /**
     * 消息时间
     */
    @BindView(R.id.activites_tv_time)
    TextView activitesTvTime;

    /**
     * 消息内容
     */
    @BindView(R.id.activites_tv_content)
    TextView activitesTvContent;

    /**
     * 活动列表
     */
    @BindView(R.id.activity_rv_img)
    RecyclerView activityRvImg;
    Unbinder unbinder;

    private ActivitesAdapter adapter;
    private List<String> img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_activites, null);
        unbinder = ButterKnife.bind(this, view);

        initData();
        initView();

        return view;
    }

    private void initData() {
        img = new ArrayList<>();
        img.add("1");
        img.add("2");
        img.add("3");
        // TODO: 2019/6/6 活动内容图片暂用一个 
    }

    private void initView() {
        adapter = new ActivitesAdapter(getActivity(),R.layout.item_activites_img,img);
        activityRvImg.setLayoutManager(new LinearLayoutManager(getActivity()));
        activityRvImg.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
