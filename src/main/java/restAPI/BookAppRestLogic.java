package restAPI;

import models.Book;

import java.util.ArrayList;

public class BookAppRestLogic implements IBookAppRestLogic{
    private IBookAppRestDB orm;

    public BookAppRestLogic(IBookAppRestDB orm) {
        this.orm = orm;
    }

    /*
    public int Login(String loginData, String password) {
        if (CheckString(loginData) && CheckString(password)){
            int userId = orm.Login(loginData, password);
            return userId;
        }
            return -1;
    }

    public boolean Register(String email, String password) {
        if (CheckString(email) && CheckString(password)){
            if (orm.CheckAvailability(email)){
                orm.Register(email,password);
                return true;
            }
        }
        return false;
    }
    */

    public boolean AddBook(Book book) {
        if (CheckString(book.getName()) && CheckString(book.getAuthor())){
            if (orm.CheckDuplicate(book.getName(), book.getAuthor())){
                orm.AddBook(book.getName(),book.getAuthor());
                return true;
            }
        }
        return false;
    }

    /*
    public boolean MoveBook(int bookId, int userId, int listId) {
        if (listId >= 0 && listId <= 2 && orm.MoveBook(bookId, userId, listId)){
            return true;
        }
        return false;
    }
    */

    public boolean EditBook(Book book){
        return orm.EditBook(book);
    }

    public ArrayList<Book> LoadBooks() {
        return orm.LoadBooks();
    }

    public boolean RemoveBook(int bookId) {
        Book book = orm.GetBookById(bookId);
        System.out.println(book.getId());
        if (book != null && orm.RemoveBook(book))
            return true;
        else
            return false;
    }

    public boolean CheckString(String text){
        if (text.matches("^[a-zA-Z0-9_@.-]+$")){
            return true;
        }
        else
            return false;
    }
}
