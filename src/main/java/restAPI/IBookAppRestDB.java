package restAPI;

import models.Book;

import java.util.ArrayList;

public interface IBookAppRestDB {
    /*
    //Login
    int Login(String loginData, String password);

    //Register
    boolean CheckAvailability(String email);

    boolean Register(String email, String password);
    */

    //Add book
    boolean CheckDuplicate (String name, String author);

    boolean AddBook(String name, String author);

    /*
    Book GetBook(String name, String author);

    //Move Book
    boolean MoveBook(int bookId, int userId, int listId);

    //Gets book id's of a user
    ArrayList<Integer> getBookIds(int userId);
    */

    //Edit Book
    boolean EditBook(Book book);

    //Load Books from Id's
    ArrayList<Book> LoadBooks();

    //Remove Book
    boolean RemoveBook(Book book);

    Book GetBookById(int bookId);
}
