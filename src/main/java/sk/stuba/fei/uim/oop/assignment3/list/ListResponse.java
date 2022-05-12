package sk.stuba.fei.uim.oop.assignment3.list;

import lombok.Getter;

@Getter
public class ListResponse {

    private final Long id;
    private final java.util.List<BookInList> lendingList;
    private final boolean lended;

    public ListResponse(List list) {
        id = list.getId();
        lendingList = list.getLendingList();
        lended = list.isLended();
    }
}
