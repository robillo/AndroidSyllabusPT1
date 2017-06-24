package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;

/**
 * Implementation of App Widget functionality.
 */
public class WidgetProvider extends AppWidgetProvider {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("RECEIVED?", "YES");
        Bundle bundle = intent.getExtras();

        if (intent.getAction().equals(AppWidgetManager.ACTION_APPWIDGET_UPDATE)) {

            Log.e("APPWIDGET_UPDATE?", "YES");

            if(bundle.getString("heading")!=null){
                String item1 = bundle.getString("heading");
                Toast.makeText(context, item1, Toast.LENGTH_SHORT).show();
                Log.e("HEADING?", item1);
                String item2 = bundle.getString("description");
                Toast.makeText(context, item2, Toast.LENGTH_SHORT).show();
                Log.e("DESCRIPTION?", item2);
            }
            else {
                Log.e("NULL H&D", "YES");
            }
        }

        super.onReceive(context, intent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int widgetId : appWidgetIds) {
            RemoteViews mView = initViews(context, appWidgetManager, widgetId);

            // Adding collection list item handler
            final Intent onItemClick = new Intent(context, WidgetProvider.class);
            onItemClick.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            onItemClick.setData(Uri.parse(onItemClick.toUri(Intent.URI_INTENT_SCHEME)));
            final PendingIntent onClickPendingIntent = PendingIntent
                    .getBroadcast(context, 0, onItemClick, PendingIntent.FLAG_UPDATE_CURRENT);
            mView.setPendingIntentTemplate(R.id.widgetCollectionList, onClickPendingIntent);

            appWidgetManager.updateAppWidget(widgetId, mView);
        }
    }

    @SuppressWarnings("deprecation")
    @SuppressLint("NewApi")
    private RemoteViews initViews(Context context, AppWidgetManager widgetManager, int widgetId) {

        RemoteViews mView = new RemoteViews("com.appbusters.robinkamboj.udacitysyllabuspart1", R.layout.widget_provider);

        Intent intent = new Intent(context, WidgetService.class);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);

        intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
        mView.setRemoteAdapter(widgetId, R.id.widgetCollectionList, intent);

        return mView;
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

