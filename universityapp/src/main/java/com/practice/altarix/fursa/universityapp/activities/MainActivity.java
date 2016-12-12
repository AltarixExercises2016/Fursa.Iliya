package com.practice.altarix.fursa.universityapp.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.adapters.TabLayoutAdapter;
import com.practice.altarix.fursa.universityapp.dialogs.AddLessonDialogFragment;
import com.practice.altarix.fursa.universityapp.dto.DbManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String MAIN_LOG = "MainActivity";

    private FloatingActionButton floatingActionButton;

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TabLayoutAdapter tabLayoutAdapter;

    private DbManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(this);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayoutAdapter = new TabLayoutAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(tabLayoutAdapter);

        tabLayout.setupWithViewPager(viewPager);

        dbManager = new DbManager();
        Toast.makeText(MainActivity.this, String.valueOf(dbManager.getRowsCount(getBaseContext())), Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onResume() {


        super.onResume();
    }

    @Override
    public void onClick(View view) {
        showAddDialog();
        Toast.makeText(getBaseContext(), "Main FAB pressed!", Toast.LENGTH_LONG).show();
    }

    private void showAddDialog() {
        AddLessonDialogFragment addLessonDialog = new AddLessonDialogFragment();
        addLessonDialog.show(getSupportFragmentManager(), "add");
    }


}
