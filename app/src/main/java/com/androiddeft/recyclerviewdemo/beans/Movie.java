package com.androiddeft.recyclerviewdemo.beans;

/**
 * Created by Abhi on 23 Sep 2017 023.
 */

public class Movie {
    private String movieName;
    private String genre;
    private Integer year;
    private Double rating;

    public Movie(String movieName, String genre, Integer year, Double rating) {
        this.movieName = movieName;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getYear() {
        return year;
    }

    public Double getRating() {
        return rating;
    }
}
