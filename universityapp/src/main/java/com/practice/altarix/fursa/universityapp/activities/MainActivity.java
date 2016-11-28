package com.practice.altarix.fursa.universityapp.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.fragments.AddLessonFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private FloatingActionButton floatingActionButton;
    private ListView daysLv;
    private Fragment addLessonFragment;
    private FragmentTransaction fragmentTransaction;
    private TextView tvInfo;
    private static final String MAIN_LOG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        daysLv = (ListView)findViewById(R.id.daysList);
        tvInfo = (TextView)findViewById(R.id.textView2);
        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);

        daysLv.setOnItemSelectedListener(this);
        floatingActionButton.setOnClickListener(this);
        addLessonFragment = AddLessonFragment.newInstance(getBaseContext());




    }

    @Override
    protected void onResume() {


        super.onResume();
    }

    @Override
    public void onClick(View view) {

        daysLv.setVisibility(View.INVISIBLE);
        tvInfo.setVisibility(View.INVISIBLE);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, addLessonFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        Toast.makeText(getBaseContext(), "Main FAB pressed!", Toast.LENGTH_LONG).show();
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        floatingActionButton.setVisibility(View.VISIBLE);
        daysLv.setVisibility(View.VISIBLE);
        tvInfo.setVisibility(View.VISIBLE);

    }


    /*
    TODO не работает получение дня из LV!!!!!
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedFromList = String.valueOf((daysLv.getItemAtPosition(i)));
        Log.d(MAIN_LOG, selectedFromList);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
