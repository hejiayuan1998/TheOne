package com.smashing.theone.common.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;

/**
 * author: chensen
 * date: 2017年04月05日17:27
 * desc:生成一个圆形的图片
 */

public class BitMapUtils {

    public static Bitmap createCircleBitmap(Bitmap src) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);

        int size = Math.min(src.getWidth(), src.getHeight());

        //新建的空白的Bitmap
        Bitmap outBitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Rect rect = new Rect(0, 0, size, size);

        Canvas canvas = new Canvas(outBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(size / 2, size / 2, size / 2, paint);


        //核心部分，设置两张图片的相交模式，在这里就是上面绘制的Circle和下面绘制的Bitmap
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(src, rect, rect, paint);

        return outBitmap;

    }


}
