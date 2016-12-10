package com.practice.altarix.fursa.universityapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.adapters.RecyclerViewAdapter;
import com.practice.altarix.fursa.universityapp.data.LessonData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xxx on 10.12.16.
 */

public class FridayFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;

    public static Fragment newInstance() {
        Bundle args = new Bundle();
        FridayFragment fragment = new FridayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private List<LessonData> initMockData() {
        List<LessonData> lessons = new ArrayList<>();
        lessons.add(new LessonData("Олимпиада", "Математика и логика", "Поляев Г.В", "15:00", 232));
        lessons.add(new LessonData("Лекция", "Программирование", "Солодов Г.И", "16:00", 605));
        lessons.add(new LessonData("Лекция", "Программирование", "Солодов Г.И", "17:00", 605));

        return lessons;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fri_fragment, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.fri_rv);
        linearLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter(initMockData());
        recyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }
}
