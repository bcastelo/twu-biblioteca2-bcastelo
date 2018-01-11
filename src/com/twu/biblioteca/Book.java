package com.twu.biblioteca;

public class Book extends ItemsToCheck{

    private String author;
    private int yearPublished;
    private boolean isCheckout;

    public Book(String title, String author, int yearPublished){
        super(title);
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getAuthor(){
        return author;
    }

    public int getYearPublished(){
        return yearPublished;
    }

    public String toString() {
        return  "\t "+getTitle()+"\t " +getAuthor()+ "\t " +getYearPublished();
    }

}
