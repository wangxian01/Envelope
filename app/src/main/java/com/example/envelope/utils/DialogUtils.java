package com.example.envelope.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.envelope.R;

/**
 * Dialog封装
 * Created by wangxian on 2019/6/11
 **/
public class DialogUtils {

    public synchronized static AlertDialog showDialog(Context context, String title, String content,
         String btnCancleText, String btnSureText, boolean touchOutside, DialogInterface.OnClickListener cancleListener,
         DialogInterface.OnClickListener sureListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(touchOutside);
        dialog.setCancelable(true);

        View view = View.inflate(context, R.layout.alert_dialog, null);
        //标题
        TextView tvTitle = view.findViewById(R.id.tv_alert_title);
        //内容
        TextView tvContent = view.findViewById(R.id.tv_alert_content);
        //取消按钮
        Button buttonCancle = view.findViewById(R.id.btn_alert_cancel);
        //确定按钮
        Button buttonOk = view.findViewById(R.id.btn_alert_ok);
        //线
        View viewLine = view.findViewById(R.id.v_alert_line);

        if (TextUtils.isEmpty(title)) {
            tvTitle.setVisibility(View.GONE);
        } else {
            tvTitle.setText(title);
        }

        tvContent.setText(TextUtils.isEmpty(content) ? "" : content);

        if (TextUtils.isEmpty(btnCancleText)) {
            buttonCancle.setVisibility(View.GONE);
            viewLine.setVisibility(View.GONE);
        } else {
            buttonCancle.setText(btnCancleText);
        }

        buttonOk.setText(TextUtils.isEmpty(btnSureText) ? "确定" : btnSureText);
        final AlertDialog dialogFinal = dialog;
        final DialogInterface.OnClickListener finalCancleListener = cancleListener;
        final DialogInterface.OnClickListener finalSureListener = sureListener;
        buttonCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalCancleListener.onClick(dialogFinal, DialogInterface.BUTTON_NEGATIVE);
            }
        });
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalSureListener.onClick(dialogFinal, DialogInterface.BUTTON_POSITIVE);
            }
        });

        //设置背景透明,去四个角
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();
        dialog.getWindow().setLayout(DensityUtils.dip2px(context, 290), LinearLayout.LayoutParams.WRAP_CONTENT);
//        dialog.getWindow().setWindowAnimations(R.style.AnimMM);
        dialog.setContentView(view);

        return dialog;
    }



}
