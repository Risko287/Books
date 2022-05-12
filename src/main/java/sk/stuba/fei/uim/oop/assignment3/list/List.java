package sk.stuba.fei.uim.oop.assignment3.list;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Setter
@Entity
public class List {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private java.util.List<BookInList> lendingList;

    private boolean lended;

    public List() {
        lendingList = new ArrayList<>();
    }
}
