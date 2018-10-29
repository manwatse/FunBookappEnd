package restAPI;

import com.google.gson.Gson;
import models.Book;
import shared.dto.request.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/bookapp")
public class BookAppRestResponse implements IBookAppRestReponse{
    private static IBookAppRestLogic logic;
    private Gson gson = new Gson();
    public static void setRestLogic(IBookAppRestLogic logic) {
        BookAppRestResponse.logic = logic;
    }

    /*
    @GET
    @Consumes("text/normal")
    @Produces("application/json")
    public Response poo(String data) {
        System.out.println("It worked!");

        return Response.status(200).entity(ResponseHelper.getLoginResultDtoString(1)).build();
    }

    @POST
    @Path("/user/login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response Login(String data) {
        LoginRequestDto loginRequestDto = gson.fromJson(data, LoginRequestDto.class);
        if (loginRequestDto == null){
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }

        int userId = logic.Login(loginRequestDto.getLoginData(), loginRequestDto.getPassword());

        return Response.status(200).entity(ResponseHelper.getLoginResultDtoString(7)).build();
    }

    @POST
    @Path("/user/register")
    @Consumes("application/json")
    @Produces("application/json")
    public Response Register(String data) {
        RegisterRequestDto registerRequestDto = gson.fromJson(data, RegisterRequestDto.class);
        if (registerRequestDto == null) {
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }

        boolean check = logic.Register(registerRequestDto.getEmail(), registerRequestDto.getPassword());
        return Response.status(200).entity(ResponseHelper.getBoolResultDtoString(check)).header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT") .build();
    }
    */

    @POST
    @Path("/action/addbook")
    @Consumes("application/json")
    @Produces("application/json")
    public Response AddBook(String data) {
        Book book = gson.fromJson(data,Book.class);
        if (book == null){
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }
        if (logic.AddBook(book))
            return Response.status(200).build();
        else
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
    }

    /*
    @PUT
    @Path("/action/movebook")
    @Consumes("application/json")
    @Produces("application/json")
    public Response MoveBook(String data) {
        MoveBookRequestDto moveBookRequestDto = gson.fromJson(data, MoveBookRequestDto.class);
        if (moveBookRequestDto == null){
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }

        boolean check = logic.MoveBook(moveBookRequestDto.getBookId(),moveBookRequestDto.getUserId(),moveBookRequestDto.getListId());
        return Response.status(200).entity(ResponseHelper.getBoolResultDtoString(check)).build();
    }
    */

    @PUT
    @Path("/action/editbook")
    @Consumes("application/json")
    @Produces("application/json")
    public Response EditBook(String data) {

        Book book = gson.fromJson(data, Book.class);
        if (book != null && logic.EditBook(book)){
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }
        else
            return Response.status(200).build();
    }


    @GET
    @Path("/action/loadbooks")
    @Produces("application/json")
    public Response LoadBooks() {

        ArrayList<Book> books = logic.LoadBooks();

        if (books == null){
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }
        else
            return Response.status(200).entity(ResponseHelper.getLoadBooksResultDtoString(books)).build();


    }

    @DELETE
    @Path("/action/removebook/{bookId}")
    @Produces("application/json")
    public Response RemoveBook(@PathParam("bookId") int data) {
        if (logic.RemoveBook(data)){
            return Response.status(200).build();
        }
        else
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();

    }
}
