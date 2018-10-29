package shared.dto.request;

import models.Book;
import shared.dto.BaseRequestDto;

public class AddBookRequestDto extends BaseRequestDto {
    Book book;
    int userId;

    public AddBookRequestDto(Book book, int userId) {
        this.book = book;
        this.userId = userId;
    }

    public Book getBook() {
        return book;
    }

    public int getUserId() {
        return userId;
    }
}
