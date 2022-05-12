package sk.stuba.fei.uim.oop.assignment3.list;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.books.Book;
import sk.stuba.fei.uim.oop.assignment3.books.BookResponse;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Setter
@Entity
public class List {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(orphanRemoval = true)
    private java.util.List<Book> lendingList;

    private boolean lended;

    public List() {
        lendingList = new ArrayList<>();
    }
}