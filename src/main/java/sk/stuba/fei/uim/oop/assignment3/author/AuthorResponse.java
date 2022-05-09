package sk.stuba.fei.uim.oop.assignment3.author;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.books.Book;

import java.util.List;

@Getter
public class AuthorResponse {

    private final long id;
    private final String name;
    private final String surname;

    private final List<Book> books;

    public AuthorResponse(Author author) {
        id = author.getId();
        name = author.getName();
        surname = author.getSurname();
        books = author.getBooks();
    }
}
