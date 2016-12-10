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


public class TuesdayFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;

    public static Fragment newInstance() {
        Bundle args = new Bundle();
        TuesdayFragment fragment = new TuesdayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private List<LessonData> initMockData() {
        List<LessonData> lessons = new ArrayList<>();
        lessons.add(new LessonData("Семинар", "Информационная безопасность", "Прокопьев Д.В", "11:00", 202));
        lessons.add(new LessonData("Олимпиада", "Информатика", "Поляев Г.В", "13:00", 202));
        lessons.add(new LessonData("Лекция", "Программирование", "Солодов Г.И", "15:00", 215));
        lessons.add(new LessonData("Олимпиада", "Математика и логика", "Поляев Г.В", "17:00", 232));
        lessons.add(new LessonData("Лекция", "Программирование", "Солодов Г.И", "19:00", 605));

        return lessons;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tue_fragment, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.tue_rv);
        linearLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter(initMockData());
        recyclerView.setAdapter(recyclerViewAdapter);

        return view;

    }
}
