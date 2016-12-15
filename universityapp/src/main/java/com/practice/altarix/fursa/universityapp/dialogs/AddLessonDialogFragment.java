package com.practice.altarix.fursa.universityapp.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.adapters.RecyclerViewAdapter;
import com.practice.altarix.fursa.universityapp.data.LessonData;
import com.practice.altarix.fursa.universityapp.dto.DbManager;
import com.practice.altarix.fursa.universityapp.dto.LessonModel;

import java.util.ArrayList;
import java.util.List;


public class AddLessonDialogFragment extends DialogFragment {
    private static final String LOG_TAG = "AddLessonDialogFragment";
    private LayoutInflater inflater;
    private Spinner type, teacher, day, lesson;
    private EditText etAuditory, etTime;
    private View view;
    private LessonModel model;
    private DbManager db;
    private List<LessonData> lessonDataList;
    private String lessonType, lessonName, lessonTeacher, lessonTime;
    private int lessonAuditory;

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.add_dialog_fragment, null);

        type = (Spinner) view.findViewById(R.id.spinnerType);
        teacher = (Spinner) view.findViewById(R.id.spinnerTeacher);
        day = (Spinner) view.findViewById(R.id.spinnerDay);
        lesson = (Spinner) view.findViewById(R.id.spinnerLesson);

        etAuditory = (EditText) view.findViewById(R.id.etAuditory);
        etTime = (EditText) view.findViewById(R.id.etTime);

        db = new DbManager();
        model = new LessonModel();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.tv_add_title);
        builder.setView(view);
        builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                lessonType = type.getSelectedItem().toString();
                lessonTeacher = teacher.getSelectedItem().toString();
                lessonName = lesson.getSelectedItem().toString();
                lessonAuditory = Integer.parseInt(etAuditory.getText().toString());
                lessonTime = etTime.getText().toString();


                model.setDay(day.getSelectedItem().toString());
                model.setLection(lesson.getSelectedItem().toString());
                model.setAuditory(Integer.parseInt(String.valueOf(etAuditory.getText())));
                model.setTeacher(teacher.getSelectedItem().toString());
                model.setTime(etTime.getText().toString());
                model.setType(type.getSelectedItem().toString());

                db.addLesson(model, getActivity());

            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        return builder.create();
    }

}
