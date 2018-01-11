package com.twu.biblioteca;

public class Movie extends ItemsToCheck{

    private String director;
    private int year;
    private int rating;
    private boolean isCheckout;

    public Movie(String title, String director, int year, int rating){
        super(title);
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public String getDirector(){
        return director;
    }

    public int getYear(){
        return year;
    }

    public int getRating(){
        return year;
    }

    public String toString() {
        return  "\t "+getTitle()+"\t " +getDirector()+ "\t " +getYear() + "\t " +getRating();
    }

}
