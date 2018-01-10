package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void findBookBangalorePublicLibrary() {
        Book book1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 2001);
        Book book2 = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", 2002);

        BangalorePublicLibrary bangalorePublicLibrary = new BangalorePublicLibrary();
        bangalorePublicLibrary.setBooks(book1);
        bangalorePublicLibrary.setBooks(book2);

        assertEquals(true, bangalorePublicLibrary.findBook("Harry Potter and the Philosopher's Stone"));
    }

    @Test
    public void notFindBookBangalorePublicLibrary() {
        Book book1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 2001);
        Book book2 = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", 2002);

        BangalorePublicLibrary bangalorePublicLibrary = new BangalorePublicLibrary();
        bangalorePublicLibrary.setBooks(book1);
        bangalorePublicLibrary.setBooks(book2);

        assertEquals(false, bangalorePublicLibrary.findBook("Harry Potter and the Prisoner of Azkaban"));
    }

    @Test
    public void getBookBangalorePublicLibrary() {
        Book book1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 2001);
        Book book2 = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", 2002);

        BangalorePublicLibrary bangalorePublicLibrary = new BangalorePublicLibrary();
        bangalorePublicLibrary.setBooks(book1);
        bangalorePublicLibrary.setBooks(book2);

        assertEquals(book1, bangalorePublicLibrary.getBook("Harry Potter and the Philosopher's Stone"));
    }

    @Test
    public void getBookNotExistBangalorePublicLibrary() {
        Book book1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 2001);
        Book book2 = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", 2002);
        Book book3 = new Book("Harry Potter and the Prisoner of Azkaban","J. K. Rowling", 2004);

        BangalorePublicLibrary bangalorePublicLibrary = new BangalorePublicLibrary();
        bangalorePublicLibrary.setBooks(book1);
        bangalorePublicLibrary.setBooks(book2);

        assertEquals(null, bangalorePublicLibrary.getBook("Harry Potter and the Prisoner of Azkaban"));
    }

    @Test
    public void listBook() {
        Book book1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 2001);
        Book book2 = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", 2002);
        Book book3 = new Book("Harry Potter and the Prisoner of Azkaban","J. K. Rowling", 2004);

        BangalorePublicLibrary bangalorePublicLibrary = new BangalorePublicLibrary();
        bangalorePublicLibrary.setBooks(book1);
        bangalorePublicLibrary.setBooks(book2);
        bangalorePublicLibrary.setBooks(book3);

        List<Book> books = new ArrayList<Book>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        assertEquals(books, bangalorePublicLibrary.getBooks());
    }

    @Test
    public void listMovie() {

        Movie movie1 = new Movie("Guerra nas Estrelas", "George Lucas", 1977, 10);
        Movie movie2 = new Movie("Guerra nas Estrelas: O Império Contra-Ataca", "Irvin Kershner", 1980, 5);
        Movie movie3 = new Movie("Star Wars: Os Últimos Jedi", "Rian Johnson", 2017, 6);

        BangalorePublicLibrary bangalorePublicLibrary = new BangalorePublicLibrary();
        bangalorePublicLibrary.setMovies(movie1);
        bangalorePublicLibrary.setMovies(movie2);
        bangalorePublicLibrary.setMovies(movie3);

        List<Movie> movies = new ArrayList<Movie>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);

        assertEquals(movies, bangalorePublicLibrary.getMovies());
    }
}
