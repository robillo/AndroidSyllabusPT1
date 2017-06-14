package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

public class RemoteViewService extends RemoteViewsService{

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {

        WidgetDataProvider dataProvider = new WidgetDataProvider(getApplicationContext(), intent);
        return dataProvider;
    }
}
