package com.twu.biblioteca;

public class Movie {

    private String title;
    private String director;
    private int year;
    private int rating;
    private boolean isCheckout;

    public Movie(String title, String director, int year, int rating){
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle(){
        return title;
    }

    public String getDirector(){
        return director;
    }

    public int getYear(){
        return year;
    }

    public void setCheckout(Boolean check){
        this.isCheckout = check;
    }

    public boolean getCheckout(){
        return isCheckout;
    }

    public int getRating(){
        return year;
    }

    public String toString() {
        return  "\t "+getTitle()+"\t " +getDirector()+ "\t " +getYear() + "\t " +getRating();
    }

}
