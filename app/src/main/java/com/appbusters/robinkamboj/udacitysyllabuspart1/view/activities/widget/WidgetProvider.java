package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.widget;

import android.annotation.SuppressLint;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;

public class WidgetProvider extends AppWidgetProvider{

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        for(int widgetId: appWidgetIds){
            RemoteViews view = initViews(context, appWidgetManager, widgetId);
            appWidgetManager.updateAppWidget(widgetId, view);

        }

        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    @SuppressLint("NewApi")
    @SuppressWarnings("deprecation")
    private RemoteViews initViews(Context context, AppWidgetManager widgetManager, int widgetId) {
        RemoteViews mView = new RemoteViews(context.getPackageName(), R.layout.widget_provider_layout);
        Intent intent = new Intent(context, RemoteViewsService.class);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);
        intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
        mView.setRemoteAdapter(widgetId, R.id.widgetCollectionList, intent);
        return mView;
    }

}
