package sk.stuba.fei.uim.oop.assignment3.list;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ListRequest {

    private Long id;
    private List<BookInList> lendingList;
    private boolean lended;

}
