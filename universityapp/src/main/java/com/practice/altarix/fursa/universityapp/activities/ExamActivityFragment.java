package com.practice.altarix.fursa.universityapp.activities;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.practice.altarix.fursa.universityapp.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ExamActivityFragment extends Fragment {

    public ExamActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_exam, container, false);
    }
}
