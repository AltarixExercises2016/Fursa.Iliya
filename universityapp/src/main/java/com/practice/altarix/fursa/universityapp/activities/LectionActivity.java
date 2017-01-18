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

public class LectionActivity extends AppCompatActivity {
    private static final String LECTION_TYPE = "Лекция";
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    ItemRecyclerViewAdapter itemRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lection);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewLection);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        itemRecyclerViewAdapter = new ItemRecyclerViewAdapter();
        itemRecyclerViewAdapter.add(loadLessons());
        recyclerView.setAdapter(itemRecyclerViewAdapter);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }
    private List<ItemDTO> loadLessons() {
        DatabaseManager databaseManager = new DatabaseManager();
        List<ItemDTO> lectionDTOList = databaseManager.getColumnsFromDb(getBaseContext(), LECTION_TYPE);
        return lectionDTOList;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                startActivity(new Intent(LectionActivity.this, MainActivity.class));
                finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
