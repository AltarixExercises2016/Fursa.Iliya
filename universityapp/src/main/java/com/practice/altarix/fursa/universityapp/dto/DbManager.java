package com.practice.altarix.fursa.universityapp.dto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.practice.altarix.fursa.universityapp.data.LessonData;

import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private static final String DB_MAN = "DBMan";
    private static final String TEACHER_TABLE = "Teacher";
    private static final String LESSONS_TABLE = "Lesson";
    private DatabaseHelper helper;
    private SQLiteDatabase db;

    public DbManager() {

    }

    public List<LessonData> getLessonsByDay(String day, Context context) {
        helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();
        List<LessonData> lessons = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT *\n" +
                "FROM Lesson, Teacher\n" +
                "WHERE Lesson.lesson_day = " + "'" + day + "'" + "AND Teacher.id = Lesson.id", null);
        if (cursor.moveToFirst()) {
            int lesson = cursor.getColumnIndex("lesson_name");
            int time = cursor.getColumnIndex("lesson_time");
            int type = cursor.getColumnIndex("lesson_type");
            int teacher = cursor.getColumnIndex("teacher_name");
            int auditory = cursor.getColumnIndex("lesson_auditory");

            do {
                lessons.add(new LessonData(cursor.getString(type), cursor.getString(lesson),
                        cursor.getString(teacher), cursor.getString(time), cursor.getInt(auditory)));
            } while (cursor.moveToNext());
        } else
            Log.d(DB_MAN, "0 rows!");
        cursor.close();
        return lessons;
    }

    public void insertLesson(LessonModel model, Context context) {
        helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues cv = new ContentValues();
            cv.put("teacher_name", model.getTeacher());
            long teacher = db.insert(TEACHER_TABLE, null, cv);
            cv.clear();
            cv.put("lesson_name", model.getLection());
            cv.put("lesson_auditory", model.getAuditory());
            cv.put("lesson_type", model.getType());
            cv.put("lesson_time", model.getTime());
            cv.put("lesson_day", model.getDay());
            long lesson = db.insert(LESSONS_TABLE, null, cv);
            Log.d(DB_MAN, "All data are saved correctly!!!!" + "Teacher id = " + teacher
                    + "Lesson id = " + lesson);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            db.close();
            helper.close();

        }
    }
}
