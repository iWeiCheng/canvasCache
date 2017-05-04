package com.jiajun.dan.canvasgpudemo;

import android.content.Context;
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
public class NoCacheView extends View {
    private Paint mPaint;
    private List<Point> mPoints;

    public NoCacheView(Context context) {
        super(context,null,0);
    }

    public NoCacheView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);
        setBackgroundColor(Color.WHITE);
        mPoints = new ArrayList<>();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mPoints.add(new Point((int) event.getX(), (int) event.getY()));
                break;
            case MotionEvent.ACTION_UP:
                invalidate();
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < mPoints.size(); i++) {
            Point p = mPoints.get(i);
            canvas.drawCircle(p.x, p.y, 50, mPaint);
        }
    }
}
