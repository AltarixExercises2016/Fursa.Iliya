package com.practice.altarix.fursa.universityapp.dto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.practice.altarix.fursa.universityapp.data.Favourite;
import com.practice.altarix.fursa.universityapp.data.LessonData;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
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
    private static final String TEACHER_FAV = "teacher_fav";
    private static final String LESSON_FAV = "lesson_fav";
    private static final java.lang.String DAY_KEY = "day_of_week";

    private DatabaseHelper helper;
    private SQLiteDatabase db;

    public DatabaseManager() {

    }

    public List<LessonData> getLessonsByDay(String day, Context context) {
        helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();
        List<LessonData> lessons = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT *\n" +
                "FROM " + LESSONS_TABLE + "," + TEACHER_TABLE +
                " WHERE Lesson.lesson_day = " + "'" + day + "'" + "AND " + LESSONS_TABLE
                + "." + LESSON_ID + "=" + TEACHER_TABLE + "." + TEACHER_ID, null);
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
            cv.put(TEACHER_FAV, model.getTeacherFav());
            long teacher = db.insert(TEACHER_TABLE, null, cv);
            cv.clear();
            cv.put(LESSON_NAME, model.getLection());
            cv.put(LESSON_AUDITORY, model.getAuditory());
            cv.put(LESSON_TYPE, model.getType());
            cv.put(LESSON_TIME, model.getTime());
            cv.put(LESSON_DAY, model.getDay());
            cv.put(LESSON_FAV, model.getLessonFav());

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

    public List<Favourite> getAllFavs(Context context) {
        List<Favourite> favs = new ArrayList<>();
        helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TEACHER_TABLE + "," + LESSONS_TABLE + " " +
                "WHERE " + TEACHER_TABLE + "." + TEACHER_ID + "=" + LESSONS_TABLE + "." + LESSON_ID + " AND " +
                TEACHER_TABLE + "." + TEACHER_FAV + "='YES' AND " + LESSONS_TABLE + "." + LESSON_FAV + "='YES';", null);
        //вывод запроса в лог!
        Log.d(DB_MAN, "SELECT * FROM " + TEACHER_TABLE + "," + LESSONS_TABLE + " " +
                "WHERE " + TEACHER_TABLE + "." + TEACHER_ID + "=" + LESSONS_TABLE + "." + LESSON_ID + " AND " +
                TEACHER_TABLE + "." + TEACHER_FAV + "='YES' AND " + LESSONS_TABLE + "." + LESSON_FAV + "='YES'");
        if(cursor.moveToFirst()) {
            int day = cursor.getColumnIndex(LESSON_DAY);
            int teacher = cursor.getColumnIndex(TEACHER_NAME);
            int auditory = cursor.getColumnIndex(LESSON_AUDITORY);
            int lesson = cursor.getColumnIndex(LESSON_NAME);
            int type = cursor.getColumnIndex(LESSON_TYPE);
            int time = cursor.getColumnIndex(LESSON_TIME);

            do {

                Log.d(DB_MAN, "TEACHER = " + cursor.getString(teacher));
                Log.d(DB_MAN, "TYPE = " + cursor.getString(type));
                Log.d(DB_MAN, "TIME = " + cursor.getString(time));
                Log.d(DB_MAN, "LESSON = " + cursor.getString(lesson));
                Log.d(DB_MAN, "AUDITORY = " + cursor.getInt(auditory));
                Log.d(DB_MAN, "DAY = " + cursor.getString(day));

                favs.add(new Favourite(cursor.getString(teacher), cursor.getString(time),  cursor.getString(type), cursor.getString(lesson), cursor.getInt(auditory),                 cursor.getString(day)));
            } while (cursor.moveToNext());
        } else {
            cursor.close();
            helper.close();
            db.close();
        }

        return favs;
    }

    public void selectAll(Context context) {
        helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TEACHER_TABLE + "," + LESSONS_TABLE + ";", null);
        if(cursor.moveToFirst()) {
            int day = cursor.getColumnIndex(LESSON_DAY);
            int teacher = cursor.getColumnIndex(TEACHER_NAME);
            int auditory = cursor.getColumnIndex(LESSON_AUDITORY);
            int lesson = cursor.getColumnIndex(LESSON_NAME);
            int type = cursor.getColumnIndex(LESSON_TYPE);
            int time = cursor.getColumnIndex(LESSON_TIME);
            int fav_teacher = cursor.getColumnIndex(TEACHER_FAV);
            int fav_lesson = cursor.getColumnIndex(LESSON_FAV);
            do {
                Log.d(DB_MAN, "======================================");
                Log.d(DB_MAN, "TEACHER = " + cursor.getString(teacher));
                Log.d(DB_MAN, "TYPE = " + cursor.getString(type));
                Log.d(DB_MAN, "TIME = " + cursor.getString(time));
                Log.d(DB_MAN, "LESSON = " + cursor.getString(lesson));
                Log.d(DB_MAN, "AUDITORY = " + cursor.getInt(auditory));
                Log.d(DB_MAN, "DAY = " + cursor.getString(day));
                Log.d(DB_MAN, "FAV TEACHER = " + cursor.getString(fav_teacher));
                Log.d(DB_MAN, "FAV LESSON = " + cursor.getString(fav_lesson));
                Log.d(DB_MAN, "======================================");
            } while (cursor.moveToNext());
        } else {
            cursor.close();
            helper.close();
            db.close();
        }
    }

    public void deleteFavItem(Context context, String day, String teacher, int auditory, String type, String time, String lesson) {
        helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();
        db.beginTransaction();
        try {
            db.rawQuery("DELETE FROM " + TEACHER_TABLE + " WHERE " + TEACHER_NAME + "='" + teacher + "' AND " + TEACHER_FAV + "='YES';", null);
            Log.d(DB_MAN, "DELETE FROM " + TEACHER_TABLE + " WHERE " + TEACHER_NAME + "='" + teacher + "' AND " + TEACHER_FAV + "='YES';");
            db.rawQuery("DELETE FROM " + LESSONS_TABLE + " WHERE " + LESSON_NAME + "='"
                    + lesson + "' AND " + LESSON_DAY + "='" + day + "' AND " + LESSON_AUDITORY + "=" + auditory + " AND " + LESSON_TYPE + "='" + type +
                    "' AND " + LESSON_TIME + "='" + time + "';", null);
            Log.d(DB_MAN, "DELETE FROM " + LESSONS_TABLE + " WHERE " + LESSON_NAME + "='"
                    + lesson + "' AND " + LESSON_DAY + "='" + day + "' AND " + LESSON_AUDITORY + "=" + auditory + " AND " + LESSON_TYPE + "='" + type +
                    "' AND " + LESSON_TIME + "='" + time + "';");
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

