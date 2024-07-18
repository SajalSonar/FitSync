package com.example.finalfitnessmad;
public class Exercise {
    private String date;
    private String bodyPart;
    private String exercise;
    private String sets;
    private String reps;

    public Exercise() {
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

}