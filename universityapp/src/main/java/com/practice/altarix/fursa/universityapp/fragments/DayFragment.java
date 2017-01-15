package com.practice.altarix.fursa.universityapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.adapters.LessonRecyclerViewAdapter;
import com.practice.altarix.fursa.universityapp.data.Days;
import com.practice.altarix.fursa.universityapp.data.LessonData;
import com.practice.altarix.fursa.universityapp.dto.DatabaseManager;

import java.util.List;


public class DayFragment extends Fragment {
    private static final String DAY_FRAGMENT_KEY = "day_of_week";
    private static final String DAY_FRAGMENT_LOG = "DayFragment";
    private static final String DAY_KEY = "day_key";
    private RecyclerView recyclerView;
    private LessonRecyclerViewAdapter lessonRecyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<LessonData> lessons;
    private int day;
    public DayFragment() {

    }
    public static Fragment newInstance(int day) {
        DayFragment fragment = new DayFragment();
        Bundle args = new Bundle();
        args.putInt(DAY_FRAGMENT_KEY, day);
        fragment.setArguments(args);
        return fragment;
    }

    public List<LessonData> initLessons() {
        DatabaseManager manager = new DatabaseManager();
        if (getArguments() != null) {
            day = getArguments().getInt(DAY_FRAGMENT_KEY);
            Log.d(DAY_FRAGMENT_LOG, String.valueOf(day));
            if (day == 0) {
                lessons = manager.getLessonsByDay(Days.MONDAY, getActivity());
            } else if (day == 1) {
                lessons = manager.getLessonsByDay(Days.TUESDAY, getActivity());
            } else if (day == 2) {
                lessons = manager.getLessonsByDay(Days.WEDNESDAY, getActivity());
            } else if (day == 3) {
                lessons = manager.getLessonsByDay(Days.THURSDAY, getActivity());
            } else if (day == 4) {
                lessons = manager.getLessonsByDay(Days.FRIDAY, getActivity());
            } else if (day == 5) {
                lessons = manager.getLessonsByDay(Days.SATURDAY, getActivity());

            }

        }
        return lessons;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.day_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.day_rv);
        linearLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        lessonRecyclerViewAdapter = new LessonRecyclerViewAdapter();
        lessonRecyclerViewAdapter.add(initLessons());
        recyclerView.setAdapter(lessonRecyclerViewAdapter);
        return view;
    }


}