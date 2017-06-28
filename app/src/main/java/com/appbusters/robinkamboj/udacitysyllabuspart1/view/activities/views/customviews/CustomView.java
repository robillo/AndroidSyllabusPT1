package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;

public class CustomView extends View{

    private static final int SQUARE_SIZE_DEF = 200;
    private Rect mRectSquare;
    private Paint mPaintSquare, mPaintCircle;
    private int mSquareColor, mSquareSize;

    public CustomView(Context context) {
        super(context);

        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    @SuppressWarnings("deprecation")
    private void init(@Nullable AttributeSet set){
        mRectSquare = new Rect();
        mPaintSquare = new Paint(Paint.ANTI_ALIAS_FLAG);

        mPaintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircle.setColor(getResources().getColor(R.color.colorAccent));

        if(set == null)
            return;


        TypedArray array = getContext().obtainStyledAttributes(set, R.styleable.CustomView);

        mSquareColor = array.getColor(R.styleable.CustomView_square_color, Color.GREEN);
        mSquareSize = array.getDimensionPixelSize(R.styleable.CustomView_square_size, SQUARE_SIZE_DEF);

        mPaintSquare.setColor(mSquareColor);

        array.recycle();
    }

    public void swapColor(){
        mPaintSquare.setColor(mPaintSquare.getColor()== mSquareColor ? Color.RED : mSquareColor);

        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mRectSquare.left = 50;
        mRectSquare.top = 50;
        mRectSquare.right = mRectSquare.left + mSquareSize;
        mRectSquare.bottom = mRectSquare.top + mSquareSize;

        canvas.drawRect(mRectSquare, mPaintSquare);

        float cx, cy;
        float radius = 100f;

        cx = getWidth() - radius - 50f;
        cy = mRectSquare.top + (mRectSquare.height()/2);

        canvas.drawCircle(cx, cy, radius, mPaintCircle);
    }
}
