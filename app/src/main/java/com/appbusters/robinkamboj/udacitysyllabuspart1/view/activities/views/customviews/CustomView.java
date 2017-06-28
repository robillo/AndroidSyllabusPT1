package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class CustomView extends View{

    private static final int SQUARE_SIZE = 200;
    private Rect rectSquare;
    private Paint paintSquare;

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
        paintSquare.setColor(Color.GREEN);
    }

    public void swapColor(){
        paintSquare.setColor(paintSquare.getColor()==Color.GREEN ? Color.RED : Color.GREEN);

        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        rectSquare.left = 50;
        rectSquare.top = 50;
        rectSquare.right = rectSquare.left + SQUARE_SIZE;
        rectSquare.bottom = rectSquare.top + SQUARE_SIZE;

        canvas.drawRect(rectSquare, paintSquare);
    }
}
