package sk.stuba.fei.uim.oop.assignment3.list;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.books.Book;
import sk.stuba.fei.uim.oop.assignment3.books.BookResponse;

import java.util.stream.Collectors;

@Getter
public class ListResponse {

    private final long id;
    private final java.util.List<BookResponse> lendingList;
    private final boolean lended;

    public ListResponse(List list) {
        id = list.getId();
        //lendingList = list.getLendingList();
        lendingList = list.getLendingList().stream().map(BookResponse::new).collect(Collectors.toList());
        lended = list.isLended();
    }
}
