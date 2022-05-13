package sk.stuba.fei.uim.oop.assignment3.list.web;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.books.web.BookResponse;
import sk.stuba.fei.uim.oop.assignment3.list.data.List;

import java.util.stream.Collectors;

@Getter
public class ListResponse {

    private final Long id;
    private final java.util.List<BookResponse> lendingList;
    private final boolean lended;

    public ListResponse(List list) {
        id = list.getId();
        lendingList = list.getLendingList().stream().map(BookResponse::new).collect(Collectors.toList());
        lended = list.isLended();
    }
}
