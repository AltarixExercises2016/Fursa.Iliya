package com.practice.altarix.fursa.universityapp.DTO;


public class ItemDTO {
    public String teacher;
    public String time;
    public String type;
    public String lesson;
    public int auditory;
    public String day;

    public ItemDTO(String favTeacher, String favTime, String favType, String favLesson, int favAuditory, String favDay) {
        this.teacher = favTeacher;
        this.time = favTime;
        this.type = favType;
        this.lesson = favLesson;
        this.auditory = favAuditory;
        this.day = favDay;
    }



}
