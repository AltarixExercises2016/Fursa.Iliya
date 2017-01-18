package com.practice.altarix.fursa.universityapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.database.DatabaseManager;
import com.practice.altarix.fursa.universityapp.database.LessonModel;


public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LESSON_LOG = "EditActivity";
    private static final String FAVOURITE = "YES";
    private static final String NO_FAVOURITE = "NO";
    private Toolbar toolbar;
    private Spinner spinnerType, spinnerTeacher, spinnerDay, spinnerLesson;
    private EditText etTime, etAuditory;
    private FloatingActionButton floatingActionButton;
    private CheckBox favCheckbox;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_lesson);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }

        spinnerDay = (Spinner) findViewById(R.id.spinnerDays);
        spinnerLesson = (Spinner) findViewById(R.id.spinnerLesson);
        spinnerType = (Spinner) findViewById(R.id.spinnerType);
        spinnerTeacher = (Spinner) findViewById(R.id.spinnerTeacher);
        favCheckbox = (CheckBox) findViewById(R.id.favCheckbox);

        etAuditory = (EditText) findViewById(R.id.etAuditory);
        etTime = (EditText) findViewById(R.id.etTime);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(this);

        intent = new Intent(this, MainActivity.class);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                startActivity(intent);
                finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.floatingActionButton: {
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
                if(favCheckbox.isChecked()) {
                    lessonModel.setTeacherFav(FAVOURITE);
                    lessonModel.setLessonFav(FAVOURITE);
                    Log.d(LESSON_LOG, "Fav chb - checked!");
                } else  {
                    lessonModel.setTeacherFav(NO_FAVOURITE);
                    lessonModel.setLessonFav(NO_FAVOURITE);
                    Log.d(LESSON_LOG, "Fav chb - not checked!");

                }

                new DatabaseManager().insertLesson(lessonModel, getApplicationContext());
                new DatabaseManager().selectAll(getApplicationContext());
                Log.d(LESSON_LOG, "Lesson - inserted");

                Snackbar.make(view, "Перейти к списку?", Snackbar.LENGTH_LONG).setAction("Да", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(intent);
                    }
                }).show();
                break;
            }

        }
    }
}