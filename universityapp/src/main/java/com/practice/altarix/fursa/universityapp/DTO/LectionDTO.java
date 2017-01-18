package com.practice.altarix.fursa.universityapp.DTO;


public class LectionDTO {
    public String type;
    public String lesson;
    public String teacher;
    public String time;
    public int auditory;


    public LectionDTO(String type, String lesson, String teacher, String time, int auditory) {
        this.type = type;
        this.lesson = lesson;
        this.teacher = teacher;
        this.time = time;
        this.auditory = auditory;
    }



}
