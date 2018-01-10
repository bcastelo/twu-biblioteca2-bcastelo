package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BangalorePublicLibrary {

    private List<Book> books = new ArrayList<Book>();
    private List<Movie> movies = new ArrayList<Movie>();

    public List<Book> getBooks() {
        return books;
    }

    public  List<Movie> getMovies(){
        return movies;
    }

    public void setBooks(Book book) {
        books.add(book);
    }

    public void setMovies(Movie movie) {
        movies.add(movie);
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
        String titleBook = scanner.nextLine();

        boolean existBook = findBook(titleBook);

        if(existBook){
            boolean bookIsDisponible = bookIsDisponible(titleBook);
            if(bookIsDisponible) {
                Book bookCheckOut = getBook(titleBook);
                setBookCheckOut(bookCheckOut);
                System.out.println("Thank you! Enjoy the book");
            } else {
                System.out.println("That book is not available.");
            }
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

    public boolean bookIsDisponible(String titleBook) {
        if(((this.getBooks().stream().filter(o -> o.getTitle().equals(titleBook)).findFirst().get().getCheckout()) == false)) {
            return true;
        } else {
            return false;
        }
    }

    public Book getBook(String titleBook) {
        return this.getBooks().stream().filter(o -> o.getTitle().equals(titleBook)).findFirst().get();
    }

    public void setBookCheckOut(Book bookCheckOut) {
        bookCheckOut.setCheckout(true);
    }

    public void returnBook() {

        System.out.println("\nWhich book(Title) do you like return?");
        Scanner scanner = new Scanner(System.in);
        String titleBook = scanner.nextLine();

        boolean existBook = findBook(titleBook);

        if (existBook) {
            boolean bookIsDisponible = bookIsDisponible(titleBook);
            if(!bookIsDisponible) {
                Book bookCheckOut = getBook(titleBook);
                setBookReturn(bookCheckOut);
                System.out.println("Thank you for returning the book.");
            } else {
                System.out.println("That is not a valid book to return.");
            }
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

    public void setBookReturn(Book bookReturn) {
        bookReturn.setCheckout(false);
    }

}
