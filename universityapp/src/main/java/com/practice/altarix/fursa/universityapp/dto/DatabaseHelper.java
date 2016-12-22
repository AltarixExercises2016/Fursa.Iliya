package com.practice.altarix.fursa.universityapp.dto;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_LOG = "DatabaseHelper";
    private static final String DB_TABLE = "LessonsTable";
    private static final String DB_NAME = "LessonsDB";
    private static final String ID = "id";
    private static final String TYPE = "lection_type";
    private static final String TEACHER = "lection_teacher";
    private static final String DAY = "lection_day_of_week";
    private static final String LECTION = "lection_name";
    private static final String AUDITORY = "lection_auditory";
    private static final String TIME = "lection_time";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(DB_LOG, "OnCreate");

        db.execSQL("CREATE TABLE "
                + DB_TABLE + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TYPE + " TEXT, "
                + TEACHER + " TEXT, "
                + DAY + " TEXT, "
                + LECTION + " TEXT, "
                + AUDITORY + " INTEGER, "
                + TIME + " TEXT" + ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
