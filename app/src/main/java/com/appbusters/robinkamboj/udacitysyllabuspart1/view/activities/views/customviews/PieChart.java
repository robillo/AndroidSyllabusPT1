package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;

public class PieChart extends View {

    Boolean showText;
    int labelPosition;

    public PieChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.PieChart, 0, 0);
        try {
            showText = a.getBoolean(R.styleable.PieChart_showText, false);
            labelPosition = a.getInteger(R.styleable.PieChart_labelPosition, 0);
        }
        finally {
            a.recycle();
        }
    }

    public boolean isShowText() {
        return this.showText;
    }

    public void setShowText(boolean showText) {
        this.showText = showText;
        invalidate();
        requestLayout();
    }
}
