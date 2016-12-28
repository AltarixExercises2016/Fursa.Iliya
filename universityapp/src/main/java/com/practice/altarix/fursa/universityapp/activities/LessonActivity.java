package com.practice.altarix.fursa.universityapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.dto.DbManager;
import com.practice.altarix.fursa.universityapp.dto.LessonModel;


public class LessonActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LESSON_LOG = "LessonActivity";
    private Toolbar toolbar;
    private Spinner spinnerType, spinnerTeacher, spinnerDay, spinnerLesson;
    private EditText etTime, etAuditory;
    private FloatingActionButton floatingActionButton;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }

        spinnerDay = (Spinner) findViewById(R.id.spinnerDay);
        spinnerLesson = (Spinner) findViewById(R.id.spinnerLesson);
        spinnerType = (Spinner) findViewById(R.id.spinnerType);
        spinnerTeacher = (Spinner) findViewById(R.id.spinnerTeacher);

        etAuditory = (EditText) findViewById(R.id.etAuditory);
        etTime = (EditText) findViewById(R.id.etTime);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton3);
        floatingActionButton.setOnClickListener(this);

        intent = new Intent(this, MainActivity.class);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        String day = spinnerDay.getSelectedItem().toString();
        String lesson = spinnerLesson.getSelectedItem().toString();
        String type = spinnerType.getSelectedItem().toString();
        String teacher = spinnerTeacher.getSelectedItem().toString();
        String time = etTime.getText().toString();
        int auditory = Integer.parseInt(etAuditory.getText().toString());

        LessonModel lessonModel = new LessonModel();
        lessonModel.setLection(lesson);
        lessonModel.setDay(day);
        lessonModel.setTeacher(teacher);
        lessonModel.setType(type);
        lessonModel.setTime(time);
        lessonModel.setAuditory(auditory);

        new DbManager().insertLesson(lessonModel, getApplicationContext());

        Snackbar.make(view, "Перейти к списку?", Snackbar.LENGTH_LONG).setAction("Да", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        }).show();

    }
}
