package sk.stuba.fei.uim.oop.assignment3.list.web;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.books.data.Book;

import java.util.List;

@Getter
@Setter
public class ListRequest {

    private Long id;
    private List<Book> lendingList;
    private boolean lended;

}
