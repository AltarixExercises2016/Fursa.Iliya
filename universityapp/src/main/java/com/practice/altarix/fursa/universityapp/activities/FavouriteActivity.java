package com.practice.altarix.fursa.universityapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.adapters.ItemRecyclerViewAdapter;
import com.practice.altarix.fursa.universityapp.DTO.ItemDTO;
import com.practice.altarix.fursa.universityapp.database.DatabaseManager;

import java.util.List;

public class FavouriteActivity extends AppCompatActivity {
    private RecyclerView recyclerViewFav;
    private ItemRecyclerViewAdapter itemRecyclerViewAdapter;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_favs);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerViewFav = (RecyclerView) findViewById(R.id.recyclerViewFav);
        recyclerViewFav.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        itemRecyclerViewAdapter = new ItemRecyclerViewAdapter();
        itemRecyclerViewAdapter.add(loadLessons());
        recyclerViewFav.setAdapter(itemRecyclerViewAdapter);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public List<ItemDTO> loadLessons() {
        DatabaseManager databaseManager = new DatabaseManager();
        List<ItemDTO> favDTOList = databaseManager.getAllFavs(getBaseContext());
        return favDTOList;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                startActivity(new Intent(FavouriteActivity.this, MainActivity.class));
                finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
