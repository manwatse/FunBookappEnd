package restAPI;

import jdk.nashorn.internal.ir.Terminal;
import models.Book;
import models.User;
import models.UsersBooksColumn;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class BookAppRestDB implements IBookAppRestDB{
    private static SessionFactory factory;
    static {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public Session getSession() {
        return factory.openSession();
    }

    public static void close() {
        factory.close();
    }

    private final static Logger logger = Logger.getLogger(BookAppRestDB.class.getName());

    public BookAppRestDB(){
        logger.setLevel(Level.INFO);
    }

    /*
    public int Login(String loginData, String password) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        try {
            List users = session.createCriteria(User.class)
                    .add(Restrictions.eq("email", loginData))
                    .add(Restrictions.eq("password", password))
                    .list();

            User u = (User)users.get(0);

            if (users.size() > 0)
                return u.getId();
            else
                return -1;
        } catch (Exception e){
            logger.info(e.getMessage());
            return -1;

        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    public boolean CheckAvailability(String email) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        try {
            List users = session.createCriteria(User.class)
                    .add(Restrictions.eq("email", email))
                    .list();

            if (users.size() == 0)
                return true;
            else
                return false;
        } catch (Exception e){
            logger.info(e.getMessage());
            return false;
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    public boolean Register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        try {
            session.save(user);
            return true;
        } catch (Exception e){
            logger.info(e.getMessage());
            return false;
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }
    */

    public boolean CheckDuplicate(String name, String author) {
        Session session = getSession();
        session.getTransaction().begin();
        try {
            List books = session.createCriteria(Book.class)
                    .add( Restrictions.eq("author", author))
                    .add( Restrictions.eq("name", name))
                    .list();

            if (books.size() > 0)
                return false;
            else
                return true;
        } catch (Exception e){
            logger.info(e.getMessage());
            return false;
        } finally {
            session.close();
        }
    }

    /*
    public Book GetBook(String name, String author) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        try {
            List books = session.createCriteria(Book.class)
                    .add( Restrictions.eq("author", author))
                    .add( Restrictions.eq("name", name))
                    .list();

            return (Book) books.get(0);
        } catch (Exception e){
            logger.info(e.getMessage());
            return null;
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    public boolean MoveBook(int bookId, int userId, int listId) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        try {
            List userbookcolums = session.createCriteria(UsersBooksColumn.class)
                    .add( Restrictions.eq("bookId", bookId))
                    .add( Restrictions.eq("userId", userId))
                    .list();

            if (userbookcolums.size() > 0){
                UsersBooksColumn ubc = (UsersBooksColumn) userbookcolums.get(0);
                ubc.setColumnId(listId);
                session.update(ubc);
            }
            else {
                UsersBooksColumn ubc = new UsersBooksColumn();
                ubc.setBookId(bookId);
                ubc.setUserId(userId);
                ubc.setColumnId(listId);

                session.save(ubc);
            }


            return true;
        } catch (Exception e){
            logger.info(e.getMessage());
            return false;
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    public ArrayList<Integer> getBookIds(int userId){
        ArrayList<Integer> bookIds = new ArrayList<Integer>();

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        try {
            List userBookColumn = session.createCriteria(UsersBooksColumn.class)
                    .add( Restrictions.eq("userId", userId))
                    .list();

            for (Object object: userBookColumn) {
                UsersBooksColumn ubc = (UsersBooksColumn)object;
                bookIds.add(ubc.getBookId());
            }
            return bookIds;
        } catch (Exception e){
            logger.info(e.getMessage());
            return null;
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }
    */

    public boolean EditBook(Book book){
        Session session = getSession();
        session.getTransaction().begin();
        try {
            System.out.println("ok1");
            session.update(book);
            return true;
        } catch (Exception e){
            logger.info(e.getMessage());
            return false;
        } finally {
            session.close();
        }
    }

    public boolean AddBook(String name, String author) {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);

        Session session = getSession();
        session.getTransaction().begin();
        try {
            System.out.println("ok2");
            session.save(book);
            return true;
        } catch (Exception e){
            logger.info(e.getMessage());
            return true;
        }finally {
            session.close();
        }
    }

    public ArrayList<Book> LoadBooks() {
        ArrayList<Book> books = new ArrayList<Book>();

        Session session = getSession();
        session.getTransaction().begin();
        try {
            System.out.println("ok5");
            List bookList = session.createCriteria(Book.class)
                        .list();

            for (Object o: bookList){
                Book book = (Book)o;
                books.add(book);
            }

            return books;
        } catch (Exception e){
            logger.info(e.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

    public boolean RemoveBook(Book book) {
        Session session = getSession();
        session.getTransaction().begin();
        try {
            System.out.println("ok3");
            session.remove(book);
            return true;
        } catch (Exception e){
            logger.info(e.getMessage());
            return false;
        } finally {
            session.close();
        }
    }

    public Book GetBookById(int bookId) {
        Session session = getSession();
        session.getTransaction().begin();
        try {
            System.out.println("ok4");
            List books = session.createCriteria(Book.class)
                    .add(Restrictions.eq("bookId", bookId))
                    .list();

            return (Book) books.get(0);
        } catch (Exception e){
            logger.info(e.getMessage());
            return null;
        } finally {
            session.close();
        }
    }
}
