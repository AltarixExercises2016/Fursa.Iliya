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

public class TestActivity extends AppCompatActivity {
    private RecyclerView recyclerViewTest;
    private ItemRecyclerViewAdapter itemRecyclerViewAdapter;
    private static final String TEST_TYPE = "Зачет";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerViewTest = (RecyclerView) findViewById(R.id.recyclerViewTest);
        recyclerViewTest.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        itemRecyclerViewAdapter = new ItemRecyclerViewAdapter();
        itemRecyclerViewAdapter.add(loadLessons());
        recyclerViewTest.setAdapter(itemRecyclerViewAdapter);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
    private List<ItemDTO> loadLessons() {
        DatabaseManager databaseManager = new DatabaseManager();
        List<ItemDTO> testDTOList = databaseManager.getColumnsFromDb(getBaseContext(), TEST_TYPE);
        return testDTOList;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                startActivity(new Intent(TestActivity.this, MainActivity.class));
                finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
