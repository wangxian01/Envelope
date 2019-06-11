package com.example.envelope.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;

public class LittieUtil {

    public static Bitmap loadBitmapFromView(@NonNull View v, int width, int height) {
        int w = DensityUtils.dip2px(v.getContext(), width);
        int h = DensityUtils.dip2px(v.getContext(), height);
        int measuredWidth = View.MeasureSpec.makeMeasureSpec(w, View.MeasureSpec.EXACTLY);
        int measureHeight = View.MeasureSpec.makeMeasureSpec(h, View.MeasureSpec.EXACTLY);
        v.measure(measuredWidth, measureHeight);
        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());

        Bitmap bitmap = Bitmap.createBitmap(v.getWidth(),v.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE);
        v.layout(0,0,v.getWidth(),v.getHeight());
        v.draw(canvas);

        return bitmap;

    }

}
