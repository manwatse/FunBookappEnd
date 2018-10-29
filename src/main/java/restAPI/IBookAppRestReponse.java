package restAPI;

import models.Book;

import javax.ws.rs.core.Response;

public interface IBookAppRestReponse {
    /*
    Response Login(String data);

    Response Register(String data);
    */

    Response AddBook(String data);

    /*
    Response MoveBook(String data);
    */

    Response EditBook(String data);

    Response LoadBooks();

    Response RemoveBook(int data);
}
