package com.practice.altarix.fursa.universityapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.adapters.FavouriteRecyclerViewAdapter;
import com.practice.altarix.fursa.universityapp.data.Favourite;
import com.practice.altarix.fursa.universityapp.dto.DatabaseManager;

import java.util.List;

public class FavouriteActivity extends AppCompatActivity {
    private RecyclerView recyclerViewFav;
    private FavouriteRecyclerViewAdapter favouriteRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_lessons);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerViewFav = (RecyclerView) findViewById(R.id.recyclerViewFav);
        recyclerViewFav.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        favouriteRecyclerViewAdapter = new FavouriteRecyclerViewAdapter();
        favouriteRecyclerViewAdapter.add(initMockData());
        recyclerViewFav.setAdapter(favouriteRecyclerViewAdapter);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public List<Favourite> initMockData() {
        DatabaseManager databaseManager = new DatabaseManager();
        List<Favourite> favouriteList = databaseManager.getAllFavs(getBaseContext());
        return favouriteList;
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
