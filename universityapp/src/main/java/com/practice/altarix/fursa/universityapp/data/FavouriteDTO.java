package com.practice.altarix.fursa.universityapp.data;


public class FavouriteDTO {
    public String favTeacher;
    public String favTime;
    public String favType;
    public String favLesson;
    public int favAuditory;
    public String favDay;

    public String getFavTeacher() {
        return favTeacher;
    }
    public void setFavTeacher(String favTeacher) {
        this.favTeacher = favTeacher;
    }
    public String getFavTime() {
        return favTime;
    }
    public void setFavTime(String favTime) {
        this.favTime = favTime;
    }
    public String getFavType() {
        return favType;
    }
    public void setFavType(String favType) {
        this.favType = favType;
    }
    public String getFavLesson() {
        return favLesson;
    }
    public void setFavLesson(String favLesson) {
        this.favLesson = favLesson;
    }
    public int getFavAuditory() {
        return favAuditory;
    }
    public void setFavAuditory(int favAuditory) {
        this.favAuditory = favAuditory;
    }
    public String getFavDay() {
        return favDay;
    }
    public void setFavDay(String favDay) {
        this.favDay = favDay;
    }
    public FavouriteDTO(String favTeacher, String favTime, String favType, String favLesson, int favAuditory, String favDay) {
        this.favTeacher = favTeacher;
        this.favTime = favTime;
        this.favType = favType;
        this.favLesson = favLesson;
        this.favAuditory = favAuditory;
        this.favDay = favDay;
    }



}
