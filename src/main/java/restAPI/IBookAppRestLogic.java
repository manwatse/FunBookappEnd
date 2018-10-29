package restAPI;

import models.Book;

import java.util.ArrayList;

public interface IBookAppRestLogic {
    /*
    //Login
    //loginData can be email
    int Login(String loginData, String password);

    //Register
    boolean Register(String email, String password);
    */

    //Add book
    boolean AddBook(Book book);

    /*
    //Move Book
    boolean MoveBook(int bookId, int userId, int listId);
    */

    //Edit book
    boolean EditBook(Book book);

    //Load Books
    ArrayList<Book> LoadBooks();

    //Remove Book
    boolean RemoveBook(int bookId);

    //Regex
    boolean CheckString(String text);

}
