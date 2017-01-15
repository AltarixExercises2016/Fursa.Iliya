package com.practice.altarix.fursa.universityapp.dto;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_LOG = "DatabaseHelper";

    public DatabaseHelper(Context context) {
        super(context, "LessonsDB", null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE `Teacher` (\n" +
                "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`teacher_fav`\tTEXT,\n" +
                "\t`teacher_name`\tTEXT\n" +
                ");\n");
        sqLiteDatabase.execSQL("PRAGMA foreign_keys=ON;\n");
        sqLiteDatabase.execSQL("CREATE TABLE `Lesson` (\n" +
                "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`lesson_name`\tTEXT,\n" +
                "\t`lesson_auditory`\tINTEGER,\n" +
                "\t`lesson_time` TEXT,\n" +
                "\t`lesson_day` TEXT,\n" +
                "\t`lesson_fav`\tTEXT,\n" +
                "\t`lesson_type` TEXT,\n" +
                "\t FOREIGN KEY(`id`) REFERENCES Teacher(id)\n" +
                ");");

        Log.d(DB_LOG, "OnCreate() - db created!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
