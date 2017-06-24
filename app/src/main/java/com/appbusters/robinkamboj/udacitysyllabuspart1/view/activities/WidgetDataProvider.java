package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.controller.MyDBHelper;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.model.Data;

import java.util.ArrayList;
import java.util.List;

public class WidgetDataProvider implements RemoteViewsService.RemoteViewsFactory{

    List<String> mCollections = new ArrayList<>();
    List<String> mCollections2 = new ArrayList<>();
    private Context context;

    private List<Data> datas = new ArrayList<>();

    public WidgetDataProvider(Context context, Intent intent) {
        this.context = context;
    }

    @Override
    public void onCreate() {
        initData();
    }

    @Override
    public void onDataSetChanged() {
        initData();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews mView = new RemoteViews(context.getPackageName(), R.layout.row_widget);
        mView.setTextViewText(R.id.word, datas.get(position).getHeading());
        mView.setTextViewText(R.id.meaning, datas.get(position).getDescription());

        //INTENT
        Intent fillInIntent = new Intent();
        fillInIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        Bundle bundle = new Bundle();
        bundle.putString("heading", datas.get(position).getHeading());
        bundle.putString("description", datas.get(position).getDescription());
        fillInIntent.putExtras(bundle);
//        fillInIntent.putExtra("heading", datas.get(position).getHeading());
//        fillInIntent.putExtra("description", datas.get(position).getDescription());
        mView.setOnClickFillInIntent(R.id.click, fillInIntent);

        return mView;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    private void initData() {
        MyDBHelper dbHelper = new MyDBHelper(context);
        datas = dbHelper.getAllData();

        Log.e("SIZERRRR", " " + datas.size());

        int position = 1;

        while (position<datas.size()){

            Log.e("SIZER", " " + datas.get(position).getHeading());
            Log.e("SIZER", " " + datas.get(position).getDescription());

            position++;
        }
    }
}
