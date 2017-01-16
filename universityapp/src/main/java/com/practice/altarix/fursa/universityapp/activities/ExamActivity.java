package com.practice.altarix.fursa.universityapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.adapters.ExamRecyclerViewAdapter;
import com.practice.altarix.fursa.universityapp.data.ExamDTO;
import com.practice.altarix.fursa.universityapp.dto.DatabaseManager;

import java.util.List;

public class ExamActivity extends AppCompatActivity {
    private RecyclerView recyclerViewExam;
    private ExamRecyclerViewAdapter examRecyclerViewAdapter;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exams);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerViewExam = (RecyclerView) findViewById(R.id.recyclerViewExam);
        recyclerViewExam.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        examRecyclerViewAdapter = new ExamRecyclerViewAdapter();
        examRecyclerViewAdapter.add(loadLessons());
        recyclerViewExam.setAdapter(examRecyclerViewAdapter);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


    }

    public List<ExamDTO> loadLessons() {
        DatabaseManager databaseManager = new DatabaseManager();
        List<ExamDTO> examDTOList = databaseManager.getAllExams(getBaseContext());
        return  examDTOList;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                startActivity(new Intent(ExamActivity.this, MainActivity.class));
                finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
