package com.practice.altarix.fursa.universityapp.data;

public class LessonDTO {
    public String type;
    public String lesson;
    public String teacher;
    public String time;
    public int auditory;


    public LessonDTO(String type, String lesson, String teacher, String time, int auditory) {
        this.type = type;
        this.lesson = lesson;
        this.teacher = teacher;
        this.time = time;
        this.auditory = auditory;
    }



}
