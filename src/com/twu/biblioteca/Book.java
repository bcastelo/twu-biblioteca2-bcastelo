package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private int yearPublished;
    private boolean isCheckout;

    public Book(String title, String author, int yearPublished){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getYearPublished(){
        return yearPublished;
    }

    public void setCheckout(Boolean check){
        this.isCheckout = check;
    }

    public boolean getCheckout(){
        return isCheckout;
    }

    public String toString() {
        return  "\t "+getTitle()+"\t " +getAuthor()+ "\t " +getYearPublished();
    }

}
