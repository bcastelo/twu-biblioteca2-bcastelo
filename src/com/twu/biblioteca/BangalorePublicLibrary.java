package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BangalorePublicLibrary {

    private List<Book> books = new ArrayList<Book>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(Book book) {
        books.add(book);
    }

    public void listBooks() {
        System.out.println("\n\nList Books!");
        System.out.println("\n\tTitle \tAuthor \tYear Published");

        for (Book book : this.getBooks()) {
            System.out.println(book.toString());
        }
    }

    public void checkout() {
        listBooks();

        System.out.println("\nWhich book(Title) do you like do checkout?");
        Scanner scanner = new Scanner(System.in);
        String titleBook = scanner.next();

        boolean existBook = findBook(titleBook);

        if(existBook){
            Book bookCheckOut = getBook(titleBook);
            setBookCheckOut(bookCheckOut);
            System.out.println("Thank you! Enjoy the book");
        } else {
            System.out.println("That book is not available.");
        }
    }

    public boolean findBook(String titleBook) {
        if((this.getBooks().stream().filter(o -> o.getTitle().equals(titleBook)).findFirst().isPresent())) {
            return true;
        } else {
            return false;
        }
    }

    public Book getBook(String titleBook) {
        for (int i = 0 ; i < books.size(); i++) {
            if(this.books.get(i).getTitle().equals(titleBook) && this.books.get(i).getCheckout() == false){
                return this.books.get(i);
            }
        }
        return null;
    }

    public void setBookCheckOut(Book bookCheckOut) {
        bookCheckOut.setCheckout(true);
    }

    public void returnBook() {

        System.out.println("\nWhich book(Title) do you like return?");
        Scanner scanner = new Scanner(System.in);
        String titleBook = scanner.next();

        if (this.getBooks().stream().filter(o -> o.getTitle().equals(titleBook)).findFirst().isPresent()) {
            for (int i = 0; i < books.size(); i++) {
                if(this.books.get(i).getTitle().equals(titleBook) && this.books.get(i).getCheckout() == true) {
                    if (this.books.get(i).getTitle().equals(titleBook)) {
                        books.get(i).setCheckout(false);
                        System.out.println("Thank you for returning the book.");
                        return;
                    }
                }
                else {
                    System.out.println("That is not a valid book to return.");
                    return;
                }
            }
        } else {
            System.out.println("That is not a valid book to return.");
            return;
        }
    }
}
