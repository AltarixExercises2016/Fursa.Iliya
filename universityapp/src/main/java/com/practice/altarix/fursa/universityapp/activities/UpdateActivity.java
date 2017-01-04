package com.practice.altarix.fursa.universityapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;

import com.practice.altarix.fursa.universityapp.R;

public class UpdateActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Intent intent;
    private Spinner spinnerTeacher, spinnerLesson, spinnerType, spinnerDay;
    private EditText etAuditory, etTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        spinnerTeacher = (Spinner) findViewById(R.id.spinnerTeacher);
        spinnerType = (Spinner) findViewById(R.id.spinnerType);
        spinnerDay = (Spinner) findViewById(R.id.spinnerDay);
        spinnerLesson = (Spinner) findViewById(R.id.spinnerLesson);
        etAuditory = (EditText) findViewById(R.id.etAuditory);
        etTime = (EditText) findViewById(R.id.etTime);

        intent = new Intent(this, MainActivity.class);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
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
}
