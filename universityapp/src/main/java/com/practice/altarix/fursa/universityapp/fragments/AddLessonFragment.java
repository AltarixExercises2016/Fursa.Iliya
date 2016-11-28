package com.practice.altarix.fursa.universityapp.fragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.practice.altarix.fursa.universityapp.dto.DatabaseHelper;
import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.dto.DbManager;
import com.practice.altarix.fursa.universityapp.dto.LessonModel;


public class AddLessonFragment extends Fragment implements View.OnClickListener{
    private FloatingActionButton floatingActionButton;
    private Spinner typeSpinner, teacherSpinner, daySpinner, lessonSpinner;
    private EditText etTime, etComment;
    private DbManager dbManager;
    private static final String ADD_LOG = "AddDialog";

    public static Fragment newInstance(Context context) {
        AddLessonFragment f = new AddLessonFragment();
        return f;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.add_fragment, container, false);
        dbManager = new DbManager();

        floatingActionButton = (FloatingActionButton)view.findViewById(R.id.floatingActionButton2);
        typeSpinner = (Spinner)view.findViewById(R.id.spinnerType);
        teacherSpinner = (Spinner)view.findViewById(R.id.spinnerTeacher);
        daySpinner = (Spinner)view.findViewById(R.id.spinnerDay);
        lessonSpinner = (Spinner)view.findViewById(R.id.spinnerLesson);
        etTime = (EditText)view.findViewById(R.id.etTime);
        etComment = (EditText)view.findViewById(R.id.etComment);

        floatingActionButton.setOnClickListener(this);
        setHasOptionsMenu(true);

        return view;
    }


    @Override
    public void onClick(View view) {
        Log.d(ADD_LOG, "Тип занятия: " + typeSpinner.getSelectedItem().toString()
                + " Препод: " + teacherSpinner.getSelectedItem().toString()
                + " День недели: " + daySpinner.getSelectedItem().toString()
                + " Дисциплина: " + lessonSpinner.getSelectedItem().toString()
                + " Время: " + etTime.getText().toString()
                + " Комментарий: " + etComment.getText().toString());

        String lectionType = typeSpinner.getSelectedItem().toString();
        String teacher = teacherSpinner.getSelectedItem().toString();
        String day = daySpinner.getSelectedItem().toString();
        String lectionName = lessonSpinner.getSelectedItem().toString();
        String time = etTime.getText().toString();
        String comment = etComment.getText().toString();


//        DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
//        ContentValues cv = new ContentValues();
//        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
//
//        cv.put("lection_type", lectionType);
//        cv.put("lection_teacher", teacher);
//        cv.put("lection_day_of_week", day);
//        cv.put("lection_name", lectionName);
//        cv.put("lection_time", time);
//        cv.put("lection_comment", comment);
//
//        long queryResult = sqLiteDatabase.insert("LessonsTable", null, cv);
//        Log.d(ADD_LOG, String.valueOf(queryResult));

        LessonModel lessonModel = new LessonModel();
        lessonModel.setType(lectionType);
        lessonModel.setTeacher(teacher);
        lessonModel.setDay(day);
        lessonModel.setLection(lectionName);
        lessonModel.setTime(time);
        lessonModel.setComment(comment);

        dbManager.addLesson(lessonModel, getActivity()); //добавление в БД!
        dbManager.deleteLesson("Охрана труда","13:00", getActivity()); //удаление из БД!

    }


}
