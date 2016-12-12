package com.practice.altarix.fursa.universityapp.dto;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_LOG = "DatabaseHelper";

    public DatabaseHelper(Context context) {
        super(context, "LessonsDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(DB_LOG, "OnCreate");

        db.execSQL("CREATE TABLE LessonsTable ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "lection_type TEXT, "
                + "lection_teacher TEXT, "
                + "lection_day_of_week TEXT, "
                + "lection_name TEXT, "
                + "lection_auditory INTEGER, "
                + "lection_time TEXT" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
