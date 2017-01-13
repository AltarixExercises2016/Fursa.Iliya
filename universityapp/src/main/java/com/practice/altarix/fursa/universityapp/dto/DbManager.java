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
    private static final String TEACHER_NAME = "teacher_name";
    private static final String LESSON_NAME = "lesson_name";
    private static final String LESSON_TYPE = "lesson_type";
    private static final String LESSON_AUDITORY = "lesson_auditory";
    private static final String LESSON_TIME = "lesson_time";
    private static final String LESSON_DAY = "lesson_day";
    private static final String TEACHER_ID = "id";
    private static final String LESSON_ID = "id";
    private static final java.lang.String DAY_KEY = "day_of_week";

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
            int lesson = cursor.getColumnIndex(LESSON_NAME);
            int time = cursor.getColumnIndex(LESSON_TIME);
            int type = cursor.getColumnIndex(LESSON_TYPE);
            int teacher = cursor.getColumnIndex(TEACHER_NAME);
            int auditory = cursor.getColumnIndex(LESSON_AUDITORY);

            do {

                lessons.add(new LessonData(cursor.getString(type), cursor.getString(lesson),
                        cursor.getString(teacher), cursor.getString(time), cursor.getInt(auditory)));
            } while (cursor.moveToNext());
        } else
            Log.d(DB_MAN, "0 rows!");
        cursor.close();
        helper.close();
        db.close();
        return lessons;
    }

    public void insertLesson(LessonModel model, Context context) {
        helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues cv = new ContentValues();
            cv.put(TEACHER_NAME, model.getTeacher());
            long teacher = db.insert(TEACHER_TABLE, null, cv);
            cv.clear();
            cv.put(LESSON_NAME, model.getLection());
            cv.put(LESSON_AUDITORY, model.getAuditory());
            cv.put(LESSON_TYPE, model.getType());
            cv.put(LESSON_TIME, model.getTime());
            cv.put(LESSON_DAY, model.getDay());
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



    public void deleteAll(Context context) {
        helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();
        db.beginTransaction();
        try {
            int resTeacher = db.delete(TEACHER_TABLE, null, null);
            int resLesson = db.delete(LESSONS_TABLE, null, null);
            Log.d(DB_MAN, "Teacher = " + resTeacher);
            Log.d(DB_MAN, "Lesson = " + resLesson);
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
