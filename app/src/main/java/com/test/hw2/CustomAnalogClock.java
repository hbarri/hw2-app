package com.test.hw2;


import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * Library analog clock class
 *
 * A widget that displays the time as a 12-at-the-top 24 hour analog clock. By
 * default, it will show the current time in the current timezone. The displayed
 * time can be set using {@link #setTime(int, int, int)}
 *
 * @author <a href="mailto:steve@staticfree.info">Steve Pomeroy</a>
 */
public class CustomAnalogClock extends View {

    public static boolean is24;
    public static boolean hourOnTop;
    private final ArrayList<DialOverlay> mDialOverlay = new ArrayList<DialOverlay>();
    private Calendar mCalendar;
    private Drawable mFace;
    private int mDialWidth;
    private float sizeScale = 1f;
    private int radius;
    private int mDialHeight;
    private int mBottom;
    private int mTop;
    private int mLeft;
    private int mRight;
    private boolean mSizeChanged;
    private HandsOverlay mHandsOverlay;
    private boolean autoUpdate;

    public CustomAnalogClock(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        handleAttrs(context, attrs);
    }

    public CustomAnalogClock(Context context, AttributeSet attrs) {
        super(context, attrs);
        handleAttrs(context, attrs);
    }

    public CustomAnalogClock(Context context) {
        super(context);
        init(context);
    }

    public CustomAnalogClock(Context context, boolean defaultWatchFace) {
        super(context);
        if (defaultWatchFace)
            init(context);
    }

    private void handleAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomAnalogClock, 0, 0);
        if (typedArray.hasValue(R.styleable.CustomAnalogClock_default_watchface)) {
            if (!typedArray.getBoolean(R.styleable.CustomAnalogClock_default_watchface, true)) {
                typedArray.recycle();
                return;
            }
        }
        init(context);
        typedArray.recycle();
    }

    public void init(Context context) {
        init(context, R.drawable.default_face, R.drawable.default_hour_hand, R.drawable.default_minute_hand, 0, false, false);
    }

    /**
     * Will set the scale of the view, for example 0.5f will draw the clock with half of its radius
     *
     * @param scale the scale to render the view in
     */
    public void setScale(float scale) {
        if (scale <= 0)
            throw new IllegalArgumentException("Scale must be bigger than 0");
        this.sizeScale = scale;
        mHandsOverlay.withScale(sizeScale);
        invalidate();
    }

    public void setFace(int drawableRes) {
        final Resources r = getResources();
        setFace(r.getDrawable(drawableRes));
    }

    public void init(Context context, @DrawableRes int watchFace, @DrawableRes int hourHand, @DrawableRes int minuteHand, int alpha, boolean is24, boolean hourOnTop) {
        CustomAnalogClock.is24 = is24;

        CustomAnalogClock.hourOnTop = hourOnTop;
        setFace(watchFace);
        Drawable Hhand = context.getResources().getDrawable(hourHand);
        assert Hhand != null;
        if (alpha > 0)
            Hhand.setAlpha(alpha);

        Drawable Mhand = context.getResources().getDrawable(minuteHand);

        mCalendar = Calendar.getInstance();

        mHandsOverlay = new HandsOverlay(Hhand, Mhand).withScale(sizeScale);
    }

    public void setFace(Drawable face) {
        mFace = face;
        mSizeChanged = true;
        mDialHeight = mFace.getIntrinsicHeight();
        mDialWidth = mFace.getIntrinsicWidth();
        radius = Math.max(mDialHeight, mDialWidth);

        invalidate();
    }

    /**
     * Sets the currently displayed time given the hour, min, and sec.
     *
     * @param hour to display on the clock
     * @param min to display on the clock
     * @param sec to display on the clock
     */
    public void setTime(int hour, int min, int sec) {
        mCalendar.set(Calendar.HOUR_OF_DAY, hour);
        mCalendar.set(Calendar.MINUTE, min);
        mCalendar.set(Calendar.SECOND, sec);

        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mSizeChanged = true;
    }

    // some parts from AnalogClock.java
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        final boolean sizeChanged = mSizeChanged;
        mSizeChanged = false;

        final int availW = mRight - mLeft;
        final int availH = mBottom - mTop;

        final int cX = availW / 2;
        final int cY = availH / 2;

        final int w = (int) (mDialWidth * sizeScale);
        final int h = (int) (mDialHeight * sizeScale);

        boolean scaled = false;

        if (availW < w || availH < h) {
            scaled = true;
            final float scale = Math.min((float) availW / (float) w,
                    (float) availH / (float) h);
            canvas.save();
            canvas.scale(scale, scale, cX, cY);
        }

        if (sizeChanged) {
            mFace.setBounds(cX - (w / 2), cY - (h / 2), cX + (w / 2), cY
                    + (h / 2));
        }

        mFace.draw(canvas);

        for (final DialOverlay overlay : mDialOverlay) {
            overlay.onDraw(canvas, cX, cY, w, h, mCalendar, sizeChanged);
        }

        mHandsOverlay.onDraw(canvas, cX, cY, w, h, mCalendar, sizeChanged);

        if (scaled) {
            canvas.restore();
        }
    }

    // from AnalogClock.java
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int finalRadius = (int) (radius * sizeScale);
        setMeasuredDimension(finalRadius, finalRadius);
    }

    @Override
    protected int getSuggestedMinimumHeight() {
        return (int) (mDialHeight * sizeScale);
    }

    @Override
    protected int getSuggestedMinimumWidth() {
        return (int) (mDialWidth * sizeScale);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right,
                            int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mRight = right;
        mLeft = left;
        mTop = top;
        mBottom = bottom;
    }
}

