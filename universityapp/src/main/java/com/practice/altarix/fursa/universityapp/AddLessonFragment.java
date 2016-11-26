package com.practice.altarix.fursa.universityapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class AddLessonFragment extends Fragment implements View.OnClickListener{
    private FloatingActionButton floatingActionButton;
    private Spinner typeSpinner, teacherSpinner, daySpinner, lessonSpinner;
    private EditText etTime, etComment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.add_fragment, container, false);

        floatingActionButton = (FloatingActionButton)view.findViewById(R.id.floatingActionButton2);
        typeSpinner = (Spinner)view.findViewById(R.id.spinnerType);
        teacherSpinner = (Spinner)view.findViewById(R.id.spinnerTeacher);
        daySpinner = (Spinner)view.findViewById(R.id.spinnerDay);
        lessonSpinner = (Spinner)view.findViewById(R.id.spinner8);
        etTime = (EditText)view.findViewById(R.id.etTime);
        etComment = (EditText)view.findViewById(R.id.editText);

        floatingActionButton.setOnClickListener(this);
        setHasOptionsMenu(true);

        return view;
    }


    @Override
    public void onClick(View view) {
        Toast.makeText(getActivity(), "FAB(2) pressed!", Toast.LENGTH_LONG).show();
    }
}
