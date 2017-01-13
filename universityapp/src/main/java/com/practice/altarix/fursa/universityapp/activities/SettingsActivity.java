package com.practice.altarix.fursa.universityapp.activities;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.dialogs.AlertDeleteDialog;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnDeleteAll;
    private DialogFragment alertDeleteDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }


        btnDeleteAll = (Button) findViewById(R.id.btnDel);
        btnDeleteAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDel: {
                alertDeleteDialog = new AlertDeleteDialog();
                alertDeleteDialog.show(getFragmentManager(), "dialog");
                break;

            }


        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                startActivity(new Intent(SettingsActivity.this, MainActivity.class));
                finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
