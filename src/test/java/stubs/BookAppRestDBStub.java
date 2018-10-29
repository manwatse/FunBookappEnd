package stubs;

import models.Book;
import restAPI.IBookAppRestDB;

import java.util.ArrayList;

public class BookAppRestDBStub implements IBookAppRestDB {
    public Book book = new Book();

    public Book getBook() {
        return book;
    }

    /*
    public int Login(String loginData, String password) {
        if (loginData.equals("admin@admin.com") && password.equals("admin"))
            return 1;
        else
            return -1;
    }

    public boolean CheckAvailability(String email) {
        if (email.equals("admin@admin.com"))
            return false;
        else
            return true;
    }

    public boolean Register(String email, String password) {
        if (email.equals("error") || password.equals("error"))
            return false;
        else
            return true;
    }
    */

    public boolean CheckDuplicate(String name, String author) {
        if (name.equals("name") && author.equals("author"))
            return false;
        else
            return true;
    }


    public boolean AddBook(String name, String author) {
        book.setName(name);
        book.setAuthor(author);
        book.setId(0);
        return true;
    }

    public boolean EditBook(Book book) {
        return true;
    }

    /*
    public Book GetBook(String name, String author) {
        if (name.equals("name") && author.equals("author")) {
            Book book = new Book();
            book.setId(1);
            book.setName("name");
            book.setAuthor("author");
            return book;
        }
        return null;
    }

    public boolean MoveBook(int bookId, int userId, int listId) {
        return true;
    }

    public ArrayList<Integer> getBookIds(int userId) {
        ArrayList<Integer> bookIds = new ArrayList<Integer>();
        if (userId == 1) {
            for (int i = 0; i <= 5; i++)
                bookIds.add(i);
        }
        return bookIds;
    }
    */

    public ArrayList<Book> LoadBooks() {
        ArrayList<Integer> bookIds = new ArrayList<Integer>();
        for (int i = 0; i <= 5; i++)
            bookIds.add(i);

        ArrayList<Book> books = new ArrayList<Book>();
        for (int i: bookIds){
            Book book = new Book();
            book.setAuthor("author"+i);
            book.setName("name" +i);
            book.setId(i);
            books.add(book);
        }
        return books;
    }

    public boolean RemoveBook(Book book) {
        return true;
    }

    public Book GetBookById(int bookId) {
        if (bookId == 1)
            return new Book("name","author");
        else
            return null;
    }
}
