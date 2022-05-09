package sk.stuba.fei.uim.oop.assignment3.books;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.author.Author;

@Getter
public class BookResponse {

    private final long id;
    private final String name;
    private final String description;
    private final long author;
    private final int pages;
    private final long amount;
    private final long lendCount;

    public BookResponse(Book book) {
        id = book.getId();
        name = book.getName();
        description = book.getDescription();
        author = book.getAuthor().getId();
        pages = book.getPages();
        amount = book.getAmount();
        lendCount = book.getLendCount();
    }
}
