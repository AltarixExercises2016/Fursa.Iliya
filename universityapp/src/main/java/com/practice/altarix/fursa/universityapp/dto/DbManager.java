package com.practice.altarix.fursa.universityapp.dto;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class DbManager {
    private DatabaseHelper databaseHelper;
    private ContentValues contentValues;
    private SQLiteDatabase sqLiteDatabase;


    private static final String DB_LOG = "DbManager";
    private String type;
    private String teacher;
    private String day;
    private String lection;
    private String time;
    private String comment;

    public DbManager() {

    }

    public void addLesson(LessonModel lessonModel, Context context) {
       contentValues = new ContentValues();
       databaseHelper = new DatabaseHelper(context) ;
       sqLiteDatabase =  databaseHelper.getWritableDatabase();

       contentValues.put("lection_type", lessonModel.getType());
       contentValues.put("lection_teacher", lessonModel.getTeacher());
       contentValues.put("lection_day_of_week", lessonModel.getDay());
       contentValues.put("lection_name", lessonModel.getLection());
       contentValues.put("lection_time", lessonModel.getTime());
       contentValues.put("lection_comment", lessonModel.getComment());

       long res = sqLiteDatabase.insert("LessonsTable", null, contentValues);
       Log.d(DB_LOG, String.valueOf(res));

    }

    public void deleteLesson(String lessonName, String lessonTime, Context context) {
        databaseHelper = new DatabaseHelper(context) ;
        sqLiteDatabase =  databaseHelper.getWritableDatabase();
        int res = sqLiteDatabase.delete("LessonsTable", "lection_time = '"+ lessonTime +"' AND lection_name = '"+ lessonName+"'", null);
        Log.d(DB_LOG, "Удалена запись id = " + String.valueOf(res));
    }

    public void updateLesson(LessonModel lessonModel, Context context) {

    }

    public int rowsCount() {
        return 0;
    }
}
