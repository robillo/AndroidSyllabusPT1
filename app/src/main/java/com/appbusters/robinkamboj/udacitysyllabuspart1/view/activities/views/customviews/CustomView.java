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
    private Rect rectSquare;
    private Paint paintSquare;
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

    private void init(@Nullable AttributeSet set){
        rectSquare = new Rect();
        paintSquare = new Paint(Paint.ANTI_ALIAS_FLAG);

        if(set == null)
            return;


        TypedArray array = getContext().obtainStyledAttributes(set, R.styleable.CustomView);

        mSquareColor = array.getColor(R.styleable.CustomView_square_color, Color.GREEN);
        mSquareSize = array.getDimensionPixelSize(R.styleable.CustomView_square_size, SQUARE_SIZE_DEF);

        paintSquare.setColor(mSquareColor);

        array.recycle();
    }

    public void swapColor(){
        paintSquare.setColor(paintSquare.getColor()== mSquareColor ? Color.RED : mSquareColor);

        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        rectSquare.left = 50;
        rectSquare.top = 50;
        rectSquare.right = rectSquare.left + mSquareSize;
        rectSquare.bottom = rectSquare.top + mSquareSize;

        canvas.drawRect(rectSquare, paintSquare);
    }
}
