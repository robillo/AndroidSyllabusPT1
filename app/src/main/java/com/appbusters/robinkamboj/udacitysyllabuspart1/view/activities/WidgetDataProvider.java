package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities;

import android.content.Context;
import android.content.Intent;
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

    List<Data> datas = new ArrayList<>();
    MyDBHelper dbHelper;

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

        Log.e("SIZER", " " + datas.get(position).getHeading());

        mView.setTextViewText(R.id.meaning, datas.get(position).getDescription());

        Log.e("SIZER", " " + datas.get(position).getDescription());

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
//        mCollections.clear();
//        mCollections2.clear();
//
//        mCollections.add("Abate");
//        mCollections2.add("To Decrease/Reduce");
//        mCollections.add("Abdicate");
//        mCollections2.add("To Give Up a Position, Right or Power");
//        mCollections.add("Aberrant");
//        mCollections2.add("Deviating From What Is Normal");
//        mCollections.add("Abeyance");
//        mCollections2.add("Temporary Suppression or Suspension");
//        mCollections.add("Abject");
//        mCollections2.add("Miserable, Pitiful");
//
//        mCollections.add("Abate");
//        mCollections2.add("To Decrease/Reduce");
//        mCollections.add("Abdicate");
//        mCollections2.add("To Give Up a Position, Right or Power");
//        mCollections.add("Aberrant");
//        mCollections2.add("Deviating From What Is Normal");
//        mCollections.add("Abeyance");
//        mCollections2.add("Temporary Suppression or Suspension");
//        mCollections.add("Abject");
//        mCollections2.add("Miserable, Pitiful");

        dbHelper = new MyDBHelper(context);
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
