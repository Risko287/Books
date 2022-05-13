package sk.stuba.fei.uim.oop.assignment3.books.web;

import lombok.Getter;

@Getter
public class BookRequest extends Amount{

    private String name;
    private String description;
    private long author;
    private int pages;
    private int lendCount;
}
