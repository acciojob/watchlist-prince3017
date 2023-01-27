package com.driver;

public class Movie {

    private String name;
    private int DurationInMinutes;
    private double imbdRating;

    public Movie(String name, int durationInMinutes, double imbdRating) {
        this.name = name;
        DurationInMinutes = durationInMinutes;
        this.imbdRating = imbdRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInMinutes() {
        return DurationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        DurationInMinutes = durationInMinutes;
    }

    public double getImbdRating() {
        return imbdRating;
    }

    public void setImbdRating(double imbdRating) {
        this.imbdRating = imbdRating;
    }
}
