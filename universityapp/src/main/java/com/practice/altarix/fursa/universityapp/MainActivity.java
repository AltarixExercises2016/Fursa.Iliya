package com.practice.altarix.fursa.universityapp;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton floatingActionButton;
    private AddLessonFragment addLessonFragment;
    private FragmentTransaction fragmentTransaction;
    private TextView tvWarning, tvWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(this);
        addLessonFragment = new AddLessonFragment();


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        floatingActionButton.setVisibility(View.INVISIBLE);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, addLessonFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        Toast.makeText(getBaseContext(), "FAB1 pressed!", Toast.LENGTH_LONG).show();


    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        floatingActionButton.setVisibility(View.VISIBLE);
    }
}
