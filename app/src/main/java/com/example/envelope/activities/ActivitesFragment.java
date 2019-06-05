package com.example.envelope.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.envelope.R;

/**
 * 活动fragment
 * Created by wangxian on 2019/6/5
 **/
public class ActivitesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_activites, null);

        return view;
    }

}
