package com.twu.biblioteca;


import org.junit.Test;
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
}
