package com.practice.altarix.fursa.universityapp.dto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.TextView;

import com.practice.altarix.fursa.universityapp.data.LessonData;

import java.util.ArrayList;
import java.util.List;


public class DbManager {
    private DatabaseHelper databaseHelper;
    private ContentValues contentValues;
    private Cursor cursor;
    private SQLiteDatabase sqLiteDatabase;


    private static final String DB_LOG = "DbManager";

    public DbManager() {

    }

    public void addLesson(LessonModel lessonModel, Context context) {
        contentValues = new ContentValues();
        databaseHelper = new DatabaseHelper(context);
        sqLiteDatabase = databaseHelper.getWritableDatabase();

        contentValues.put("lection_type", lessonModel.getType());
        contentValues.put("lection_teacher", lessonModel.getTeacher());
        contentValues.put("lection_day_of_week", lessonModel.getDay());
        contentValues.put("lection_name", lessonModel.getLection());
        contentValues.put("lection_auditory", lessonModel.getAuditory());
        contentValues.put("lection_time", lessonModel.getTime());

        long res = sqLiteDatabase.insert("LessonsTable", null, contentValues);
        Log.d(DB_LOG, String.valueOf(res));

    }

    public void deleteLesson(String lessonName, String lessonTime, Context context) {
        databaseHelper = new DatabaseHelper(context);
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        int res = sqLiteDatabase.delete("LessonsTable", "lection_time = '" + lessonTime + "' AND lection_name = '" + lessonName + "'", null);
        Log.d(DB_LOG, "Удалена запись id = " + String.valueOf(res));
    }

    public void updateLesson(LessonModel lessonModel, Context context) {

    }

    public void selectAll(Context context) {
        databaseHelper = new DatabaseHelper(context);
        sqLiteDatabase = databaseHelper.getReadableDatabase();
        cursor = sqLiteDatabase.query("LessonsTable", null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            int id = cursor.getColumnIndex("id");
            int type = cursor.getColumnIndex("lection_type");
            int teacher = cursor.getColumnIndex("lection_teacher");
            int day = cursor.getColumnIndex("lection_day_of_week");
            int lection = cursor.getColumnIndex("lection_name");
            int time = cursor.getColumnIndex("lection_time");
            int auditory = cursor.getColumnIndex("lection_auditory");

            do {
                Log.d(DB_LOG,
                        "------------------- \n ID = " + cursor.getInt(id) + '\n'
                                + "TYPE = " + cursor.getString(type) + '\n'
                                + "TEACHER = " + cursor.getString(teacher) + '\n'
                                + "DAY = " + cursor.getString(day) + '\n'
                                + "LECTION = " + cursor.getString(lection) + '\n'
                                + "AUDITORY = " + cursor.getInt(auditory) + '\n'
                                + "TIME = " + cursor.getString(time) +
                                "\n----------------- \n");

            } while (cursor.moveToNext());
        } else
            Log.d(DB_LOG, "0 rows!!!");
        cursor.close();
    }

    public List<LessonData> selectLessonsByDay(String day, Context context) {
        ArrayList<LessonData> lessonsList = new ArrayList<>();
        String query = "SELECT * FROM LessonsTable WHERE lection_day_of_week = " + "'" + day + "'";
        databaseHelper = new DatabaseHelper(context);
        sqLiteDatabase = databaseHelper.getReadableDatabase();
        cursor = sqLiteDatabase.rawQuery(query, null);

        if(cursor.moveToFirst()) {
            int type = cursor.getColumnIndex("lection_type");
            int teacher = cursor.getColumnIndex("lection_teacher");
            int lection = cursor.getColumnIndex("lection_name");
            int time = cursor.getColumnIndex("lection_time");
            int auditory = cursor.getColumnIndex("lection_auditory");

            do {
                String lessonType = cursor.getString(type);
                String lessonTeacher = cursor.getString(teacher);
                String lessonName = cursor.getString(lection);
                String lessonTime = cursor.getString(time);
                int lessonAuditory = cursor.getInt(auditory);

                lessonsList.add(new LessonData(lessonType, lessonTeacher,
                        lessonName, lessonTime, lessonAuditory));

            } while (cursor.moveToNext());
        } else Log.d(DB_LOG, "0 rows!!!");
        cursor.close();

        return lessonsList;
    }

    public int getRowsCount(Context context) {
        String query = "SELECT * FROM LessonsTable";
        databaseHelper = new DatabaseHelper(context);
        sqLiteDatabase = databaseHelper.getReadableDatabase();
        cursor = sqLiteDatabase.rawQuery(query, null);
        int counter = cursor.getCount();
        cursor.close();
        return counter;
    }

    public int checkCountOfLessons(String day, Context context) {
        String query = "SELECT * FROM LessonsTable WHERE lection_day_of_week = " + "'" + day + "'";
        databaseHelper = new DatabaseHelper(context);
        sqLiteDatabase = databaseHelper.getReadableDatabase();
        cursor = sqLiteDatabase.rawQuery(query, null);
        int counter = cursor.getCount();
        cursor.close();
        return counter;
    }

}
