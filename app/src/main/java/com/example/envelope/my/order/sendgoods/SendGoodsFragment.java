package com.example.envelope.my.order.sendgoods;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.envelope.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SendGoodsFragment extends Fragment {


    public SendGoodsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fg_send_goods, container, false);
    }

}
