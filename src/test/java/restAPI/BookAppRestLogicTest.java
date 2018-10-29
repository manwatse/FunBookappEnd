package restAPI;

import models.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stubs.BookAppRestDBStub;

import java.util.ArrayList;

public class BookAppRestLogicTest {
    private BookAppRestDBStub orm = new BookAppRestDBStub();
    private BookAppRestLogic logic = new BookAppRestLogic(orm);
    private Book book = new Book();
    private ArrayList<Book> books = new ArrayList<Book>();
    @Before
    public void before(){
        book.setId(1);
        book.setName("name");
        book.setAuthor("author");

        for(int i = 0; i <= 5; i++){
            Book book = new Book();
            book.setAuthor("author"+i);
            book.setName("name" +i);
            book.setId(i);
            books.add(book);
        }
    }
    /*
    @Test
    public void login() {
        Assert.assertEquals(1,logic.Login("admin@admin.com", "admin"));
        Assert.assertEquals(-1,logic.Login("notadmin@notadmin.com", "notadmin"));
    }

    @Test
    public void register() {
        Assert.assertFalse(logic.Register("admin@admin.com", "admin"));
        Assert.assertTrue(logic.Register("notadmin@admin.com", "admin"));
    }
    */

    @Test
    public void addBook() {
        Assert.assertFalse(logic.AddBook(new Book("name", "author")));
        Assert.assertTrue(logic.AddBook(new Book("notname", "notauthor")));
    }

    /*
    @Test
    public void moveBook() {
        Assert.assertTrue(logic.MoveBook(1,1,1));
        Assert.assertFalse(logic.MoveBook(1,1,4));
    }
    */

    /*
    @Test
    public void loadBooks() {
        ArrayList<Book> books2 = logic.LoadBooks();
        int i = 0;
        for (Book b: books2) {
            Book book = books.get(i);
            Assert.assertEquals(book.getAuthor(), b.getAuthor());
            Assert.assertEquals(book.getId(), b.getId());
            Assert.assertEquals(book.getName(), b.getName());
            i++;
        }
    }
    */

    @Test
    public void checkString(){
        Assert.assertTrue(logic.CheckString("abcdefghijklmnopqrstuvwxyz1234567890_-@."));
        Assert.assertFalse(logic.CheckString("!#$%^&*()"));
    }

    @Test
    public void removeBook(){
        Assert.assertTrue(logic.RemoveBook(1));
        Assert.assertFalse(logic.RemoveBook(0));
    }
}
