package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.widget;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViewsService;

@SuppressLint("NewApi")
public class RemoteViewService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {

        WidgetDataProvider dataProvider = new WidgetDataProvider(getApplicationContext(), intent);
        Log.e("RVS", String.valueOf(dataProvider.getCount()));
        return dataProvider;
    }
}
