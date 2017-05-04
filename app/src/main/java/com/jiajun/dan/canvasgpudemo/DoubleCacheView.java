package com.jiajun.dan.canvasgpudemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danjj on 2017/5/4.
 */
public class DoubleCacheView extends View {
    private Paint mPaint;
    private Canvas mBufferCanvas;
    private Bitmap mBufferBitmap;

    public DoubleCacheView(Context context) {
        super(context);
    }

    public DoubleCacheView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);
        setBackgroundColor(Color.WHITE);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                if (mBufferBitmap == null) {
                    mBufferBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                    mBufferCanvas = new Canvas(mBufferBitmap);
                }
                mBufferCanvas.drawCircle((int) event.getX(), (int) event.getY(), 50, mPaint);
                break;
            case MotionEvent.ACTION_UP:
                invalidate();
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mBufferBitmap == null) {
            return;
        }
        canvas.drawBitmap(mBufferBitmap, 0, 0, null);
    }
}
