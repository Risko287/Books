package sk.stuba.fei.uim.oop.assignment3.list.data;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.books.data.Book;

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
    private java.util.List<Book> lendingList;

    private boolean lended;

    public List() {
        lendingList = new ArrayList<>();
    }
}
