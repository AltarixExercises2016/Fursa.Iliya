package com.practice.altarix.fursa.universityapp.adapters;


import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.practice.altarix.fursa.universityapp.R;
import com.practice.altarix.fursa.universityapp.activities.UpdateActivity;
import com.practice.altarix.fursa.universityapp.data.LessonData;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.LessonViewHolder> {
    private List<LessonData> lessonList;


    public RecyclerViewAdapter() {
    }

    @Override
    public LessonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LessonViewHolder holder, int position) {
        LessonData data = lessonList.get(position);

        holder.tvLesson.setText(String.valueOf(data.lesson));
        holder.tvAuditory.setText(String.valueOf(data.auditory));
        holder.tvTime.setText(String.valueOf(data.time));
        holder.tvTeacher.setText(String.valueOf(data.teacher));
        holder.tvType.setText(String.valueOf(data.type));

    }

    public void add(List<LessonData> lessonList) {
        this.lessonList = lessonList;
    }

    @Override
    public int getItemCount() {
        return lessonList.size();
    }

    public static class LessonViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        private static final String LESSON_KEY = "Lesson";
        private static final String TYPE_KEY = "Type";
        private static final String TEACHER_KEY = "Teacher";
        private static final String AUDITORY_KEY = "Auditory";
        private static final String TIME_KEY = "Time";
        CardView lessonCard;
        TextView tvType, tvTeacher, tvAuditory, tvTime, tvLesson;

        public LessonViewHolder(View itemView) {
            super(itemView);
            lessonCard = (CardView) itemView.findViewById(R.id.cv);
            tvType = (TextView) itemView.findViewById(R.id.tv_type);
            tvTeacher = (TextView) itemView.findViewById(R.id.tv_teacher);
            tvAuditory = (TextView) itemView.findViewById(R.id.tv_auditory);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            tvLesson = (TextView) itemView.findViewById(R.id.tv_lesson);

            itemView.setOnLongClickListener(this);


        }


        @Override
        public boolean onLongClick(View view) {
            Toast.makeText(view.getContext(), "test", Toast.LENGTH_LONG).show();
            String lesson = tvLesson.getText().toString();
            String type = tvType.getText().toString();
            String teacher = tvTeacher.getText().toString();
            int auditory = Integer.parseInt((String) tvAuditory.getText());
            String time = tvTime.getText().toString();

            Intent intent = new Intent(view.getContext(), UpdateActivity.class);
            intent.putExtra(LESSON_KEY, lesson);
            intent.putExtra(TYPE_KEY, type);
            intent.putExtra(TEACHER_KEY, teacher);
            intent.putExtra(AUDITORY_KEY, auditory);
            intent.putExtra(TIME_KEY, time);
            Toast.makeText(view.getContext(),
                    "Lesson = " + lesson
                            + "Type = " + type
                            + "Teacher = " + teacher
                            + "Time = " + time
                            + "Auditory = " + auditory,
                    Toast.LENGTH_SHORT).show();

            //передача параметров в класс UpdateActivity для испоьзования в запросе Update
            view.getContext().startActivity(intent);
            return false;
        }
    }

}


