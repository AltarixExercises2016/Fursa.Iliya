package com.practice.altarix.fursa.universityapp.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.adapters.TabLayoutAdapter;
import com.practice.altarix.fursa.universityapp.fragments.AddLessonFragment;
import com.practice.altarix.fursa.universityapp.fragments.MondayFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TabLayout.OnTabSelectedListener {
    private static final String MAIN_LOG = "MainActivity";

    private FloatingActionButton floatingActionButton;
    private Fragment addLessonFragment;
    private FragmentTransaction fragmentTransaction;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TabLayoutAdapter tabLayoutAdapter;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(this);
        addLessonFragment = AddLessonFragment.getInstance();
        tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.addOnTabSelectedListener(this);

        tabLayoutAdapter = new TabLayoutAdapter(getSupportFragmentManager());
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPager.setAdapter(tabLayoutAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }




    @Override
    protected void onResume() {


        super.onResume();
    }

    @Override
    public void onClick(View view) {
        tabLayout.setVisibility(View.INVISIBLE);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, addLessonFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        Toast.makeText(getBaseContext(), "Main FAB pressed!", Toast.LENGTH_LONG).show();
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        tabLayout.setVisibility(View.VISIBLE);
        floatingActionButton.setVisibility(View.VISIBLE);

    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
       String day = String.valueOf(tab.getText());

        switch (day) {
            case "Понедельник":
                Toast.makeText(getBaseContext(), "ПН", Toast.LENGTH_LONG).show();
                break;
            case "Вторник":
                Toast.makeText(getBaseContext(), "ВТ", Toast.LENGTH_LONG).show();
            case "Среда":
                Toast.makeText(getBaseContext(), "СР", Toast.LENGTH_LONG).show();
                break;
            case "Четверг":
                Toast.makeText(getBaseContext(), "ЧТ", Toast.LENGTH_LONG).show();

            case "Пятница":
                Toast.makeText(getBaseContext(), "ПТ", Toast.LENGTH_LONG).show();
                break;
            case "Суббота":
                Toast.makeText(getBaseContext(), "СБ", Toast.LENGTH_LONG).show();

          }

        }


    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
