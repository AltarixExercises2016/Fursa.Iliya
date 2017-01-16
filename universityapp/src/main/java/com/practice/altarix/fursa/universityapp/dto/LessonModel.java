package com.practice.altarix.fursa.universityapp.dto;


public class LessonModel {
    private String type;
    private String teacher;
    private String day;
    private String lection;
    private String time;
    private int auditory;
    private String teacherFav;
    private String lessonFav;

    public LessonModel() {

    }

    public LessonModel(String type, int auditory, String time, String lection,
                       String teacher, String day, String teacherFav, String lessonFav) {
        this.type = type;
        this.time = time;
        this.lection = lection;
        this.teacher = teacher;
        this.day = day;
        this.auditory = auditory;
        this.lessonFav = lessonFav;
        this.teacherFav = teacherFav;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getLection() {
        return lection;
    }

    public void setLection(String lection) {
        this.lection = lection;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAuditory() {
        return auditory;
    }

    public void setAuditory(int auditory) {
        this.auditory = auditory;
    }

    public String getLessonFav() {
        return lessonFav;
    }

    public void setLessonFav(String lessonFav) {
        this.lessonFav = lessonFav;
    }

    public String getTeacherFav() {
        return teacherFav;
    }

    public void setTeacherFav(String teacherFav) {
        this.teacherFav = teacherFav;
    }


}
