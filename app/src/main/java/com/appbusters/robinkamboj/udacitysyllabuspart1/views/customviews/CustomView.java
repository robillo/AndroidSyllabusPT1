package com.appbusters.robinkamboj.udacitysyllabuspart1.views.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;

public class CustomView extends View{

    private static final int SQUARE_SIZE_DEF = 200;
    private Rect mRectSquare;
    private Paint mPaintSquare, mPaintCircle;
    private int mSquareColor, mSquareSize;
    private float mCircleX, mCircleY;
    private float mCircleRadius = 100f;

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

        if(mCircleX == 0f || mCircleY == 0f){
            mCircleX = getWidth()/2;
            mCircleY = getHeight()/2;
        }

        canvas.drawCircle(mCircleX, mCircleY, mCircleRadius, mPaintCircle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value = super.onTouchEvent(event);

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                float x = event.getX();
                float y = event.getY();

                if(mRectSquare.left < x && mRectSquare.right > x){
                    if(mRectSquare.top<y && mRectSquare.bottom > y){
                        mCircleRadius+=10;
                        postInvalidate();
                    }
                }
                return true;
            }
            case MotionEvent.ACTION_MOVE:{
                float x = event.getX();
                float y = event.getY();

                double dx = Math.pow(x - mCircleX, 2);
                double dy = Math.pow(y - mCircleY, 2);

                if(dx + dy < Math.pow(mCircleRadius, 2)){
                    //TOUCHED

                    mCircleX = x;
                    mCircleY = y;

                    postInvalidate();

                    return true;
                }

                return true;
            }
        }

        return value;
    }
}
