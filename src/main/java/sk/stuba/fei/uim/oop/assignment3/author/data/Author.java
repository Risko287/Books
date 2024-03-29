package sk.stuba.fei.uim.oop.assignment3.author.data;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.books.data.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @OneToMany(orphanRemoval = true)
    private List<Book> books;

    public Author() {
        books = new ArrayList<>();
    }
}
