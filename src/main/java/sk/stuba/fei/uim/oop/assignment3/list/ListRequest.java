package sk.stuba.fei.uim.oop.assignment3.list;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.books.Book;

@Getter
public class ListRequest {

    private java.util.List<Book> lendingList;

    private boolean lended;
}
