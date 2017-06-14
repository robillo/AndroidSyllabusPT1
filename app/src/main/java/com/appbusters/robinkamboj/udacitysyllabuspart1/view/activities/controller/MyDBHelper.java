package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.model.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MyDBHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "saveddata.db";
    private static final String TABLE_NAME = "SAVED_DATA";

    private static final String HEADING = "heading";
    private static final String DESCRIPTION = "Description";
    private Context context;

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(" + HEADING + " TEXT PRIMARY KEY," + DESCRIPTION + " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void createItem(String heading, String description){

        if(!checkIfSaved(heading)){
            Toast.makeText(context, R.string.different, Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(HEADING + " ", heading);
        contentValues.put(DESCRIPTION + " ", description);
        database.insert(TABLE_NAME, null, contentValues);
        Toast.makeText(context, "ITEM ADDED TO LIST", Toast.LENGTH_SHORT).show();
    }

    private Cursor getItem(String heading){
        SQLiteDatabase database = this.getReadableDatabase();
        return database.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + HEADING + "=\'" + heading + "\'", null);
    }

    public boolean checkIfSaved(String heading){
        Cursor c = getItem(heading);
        return c.getColumnIndex(HEADING) == -1;
    }

    public Data getSingleData(String heading){
        Cursor c = getItem(heading);
        c.moveToFirst();
        return new Data(c.getString(c.getColumnIndex(heading)), c.getString(c.getColumnIndex(DESCRIPTION)));
    }

    public List<Data> getAllData(){
        List<Data> data = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM " + TABLE_NAME + " ", null);
        if(c!=null){
            c.moveToFirst();
            while (!c.isAfterLast()){
                data.add(new Data(c.getString(c.getColumnIndex(HEADING)), c.getString(c.getColumnIndex(DESCRIPTION))));
                c.moveToNext();
            }
        }
        if (c != null) {
            c.close();
        }
        return data;
    }

    public void delete(String heading){
        SQLiteDatabase database = this.getReadableDatabase();
        database.delete(TABLE_NAME, HEADING + "=? ", new String[]{heading});
        Toast.makeText(context, "Item Deleted From List", Toast.LENGTH_SHORT).show();
    }

    public int numberOfRows(){
        SQLiteDatabase database = getReadableDatabase();
        return (int) DatabaseUtils.queryNumEntries(database, TABLE_NAME);
    };
}
