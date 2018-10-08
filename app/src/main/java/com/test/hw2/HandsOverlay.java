package com.test.hw2;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import java.util.Calendar;

/**
 * Library analog clock class
 */
public class HandsOverlay implements DialOverlay {

    private final Drawable mHour;
    private final Drawable mMinute;
    private final boolean mUseLargeFace;
    private float mHourRot;
    private float mMinRot;
    private boolean mShowSeconds;
    private float scale;

    public HandsOverlay(Drawable hourHand, Drawable minuteHand) {
        mUseLargeFace = false;

        mHour = hourHand;
        mMinute = minuteHand;
    }
    public HandsOverlay withScale(float scale){
        this.scale = scale;
        return this;
    }

    public static float getHourHandAngle(int h, int m) {
        return CustomAnalogClock.is24 ? ((12 + h) / 24.0f * 360) % 360 + (m / 60.0f) * 360 / 24.0f : ((12 + h) / 12.0f * 360) % 360 + (m / 60.0f) * 360 / 12.0f;
    }

    @Override
    public void onDraw(Canvas canvas, int cX, int cY, int w, int h, Calendar calendar,
                       boolean sizeChanged) {

        updateHands(calendar);

        canvas.save();
        if (!CustomAnalogClock.hourOnTop)
            drawHours(canvas, cX, cY, w, h, calendar, sizeChanged);
        else
            drawMinutes(canvas, cX, cY, w, h, calendar, sizeChanged);
        canvas.restore();

        canvas.save();
        if (!CustomAnalogClock.hourOnTop)
            drawMinutes(canvas, cX, cY, w, h, calendar, sizeChanged);
        else
            drawHours(canvas, cX, cY, w, h, calendar, sizeChanged);
        canvas.restore();
    }

    private void drawMinutes(Canvas canvas, int cX, int cY, int w, int h, Calendar calendar,
                             boolean sizeChanged) {
        canvas.rotate(mMinRot, cX, cY);

        if (sizeChanged) {
            w = (int) (mMinute.getIntrinsicWidth() * scale);
            h = (int) (mMinute.getIntrinsicHeight() * scale);
            mMinute.setBounds(cX - (w / 2), cY - (h / 2), cX + (w / 2), cY + (h / 2));
        }
        mMinute.draw(canvas);
    }

    private void drawHours(Canvas canvas, int cX, int cY, int w, int h, Calendar calendar,
                           boolean sizeChanged) {
        canvas.rotate(mHourRot, cX, cY);

        if (sizeChanged) {
            w = (int) (mHour.getIntrinsicWidth()* scale);
            h = (int) (mHour.getIntrinsicHeight()* scale);
            mHour.setBounds(cX - (w / 2), cY - (h / 2), cX + (w / 2), cY + (h / 2));
        }
        mHour.draw(canvas);
    }

    private void updateHands(Calendar calendar) {

        final int h = calendar.get(Calendar.HOUR_OF_DAY);
        final int m = calendar.get(Calendar.MINUTE);
        final int s = calendar.get(Calendar.SECOND);

        mHourRot = getHourHandAngle(h, m);
        mMinRot = (m / 60.0f) * 360 + (mShowSeconds ? ((s / 60.0f) * 360 / 60.0f) : 0);
    }

}
