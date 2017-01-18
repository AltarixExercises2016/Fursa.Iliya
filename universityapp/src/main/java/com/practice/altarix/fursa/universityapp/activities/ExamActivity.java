package com.practice.altarix.fursa.universityapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.practice.altarix.fursa.universityapp.DTO.ItemDTO;
import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.adapters.ItemRecyclerViewAdapter;
import com.practice.altarix.fursa.universityapp.database.DatabaseManager;

import java.util.List;

public class ExamActivity extends AppCompatActivity {
    private RecyclerView recyclerViewExam;
    private ItemRecyclerViewAdapter recyclerViewAdapter;
    private Toolbar toolbar;
    private static final String EXAM_TYPE = "Экзамен";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exams);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerViewExam = (RecyclerView) findViewById(R.id.recyclerViewExam);
        recyclerViewExam.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerViewAdapter = new ItemRecyclerViewAdapter();
        recyclerViewAdapter.add(loadLessons());
        recyclerViewExam.setAdapter(recyclerViewAdapter);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


    }

    public List<ItemDTO> loadLessons() {
        DatabaseManager databaseManager = new DatabaseManager();
        List<ItemDTO> examDTOList = databaseManager.getColumnsFromDb(getBaseContext(), EXAM_TYPE);
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
