package com.practice.altarix.fursa.universityapp.activities;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.adapters.TabLayoutAdapter;
import com.practice.altarix.fursa.universityapp.dialogs.InfoDialogFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    private static final String MAIN_LOG = "MainActivity";
    private FloatingActionButton floatingActionButton;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TabLayoutAdapter tabLayoutAdapter;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

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

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name);
            drawerLayout.addDrawerListener(toggle);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawerLayout.openDrawer(Gravity.LEFT);
                }
            });

            toggle.syncState();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, LessonActivity.class));
        Toast.makeText(getBaseContext(), "Main FAB pressed!", Toast.LENGTH_LONG).show();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawers();
        switch (item.getItemId()) {
            case R.id.nav_teacher: {
                Toast.makeText(this, "Teacher", Toast.LENGTH_SHORT).show();
               // startActivity(new Intent(MainActivity.this, TeacherActivity.class));
                break;
            }
            case R.id.nav_lessons: {
                Toast.makeText(this, "All lessons", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.nav_settings: {
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                break;
            }
            case R.id.nav_about: {
                DialogFragment infoDialogFragment = new InfoDialogFragment();
                infoDialogFragment.show(getFragmentManager(), "info");
                break;
            }

        }
        return false;
    }


}
