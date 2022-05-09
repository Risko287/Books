package sk.stuba.fei.uim.oop.assignment3.books;

import lombok.Getter;

@Getter
public class BookRequest {

    private String name;
    private String description;
    private long author;
    private int pages;
    private long amount;
    private long lendCount;
}
