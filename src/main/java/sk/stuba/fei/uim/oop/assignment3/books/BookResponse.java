package sk.stuba.fei.uim.oop.assignment3.books;

import lombok.Getter;

@Getter
public class BookResponse {

    private final Long id;
    private final String name;
    private final String description;
    private final Long author;
    private final int pages;
    private final Long amount;
    private final Long lendCount;

    public BookResponse(Book book) {
        id = book.getId();
        name = book.getName();
        description = book.getDescription();
        author = book.getAuthor();
        pages = book.getPages();
        amount = book.getAmount();
        lendCount = book.getLendCount();
    }
}
