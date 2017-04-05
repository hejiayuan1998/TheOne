package com.smashing.theone.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * author: chensen
 * date: 2017年04月05日8:14
 * desc: 圆形图片
 */

public class CircleImageView extends android.support.v7.widget.AppCompatImageView {


    public CircleImageView(Context context) {
        super(context);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//
//        Drawable drawable = getDrawable();
//
//        //空值判断，必要步骤，避免由于没有设置src导致的异常错误
//        if (drawable == null) {
//            return;
//        }
//
//        if (!(drawable instanceof BitmapDrawable)) {
//            return;
//        }
//
//
//        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
//        Bitmap roundBimmap = getCroppedBitmap(bitmap, bitmap.getWidth());
//        canvas.drawBitmap(roundBimmap, 0, 0, null);


    }


 //   public static Bitmap getCroppedBitmap(Bitmap bitmap, int radius) {
//        final int color = 0xff424242;
//        Paint paint = new Paint();
//
//        //比较初始Bitmap宽高和给定的圆形直径，判断是否需要缩放裁剪Bitmap对象
//        Bitmap outBitmap;
//
//        if (bitmap.getWidth() != radius || bitmap.getHeight() != radius) {
//            outBitmap =
//        } else {
//
//        }
//
//
//        = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(outBitmap);
//
//        Rect rect = new Rect(0, 0, outBitmap.getWidth(), outBitmap.getHeight());
//
//        paint.setAntiAlias(true);
//        paint.setColor(color);
//
//        canvas.drawARGB(0, 0, 0, 0);//背景透明
//        canvas.drawCircle(outBitmap.getWidth() / 2, outBitmap.getHeight() / 2, outBitmap.getWidth() / 2, paint);
//
//        //核心部分，设置两张图片的相交模式，在这里就是上面绘制的Circle和下面绘制的Bitmap
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
//        canvas.drawBitmap(outBitmap, rect, rect, paint);
//
//        return outBitmap;
 //   }
}
