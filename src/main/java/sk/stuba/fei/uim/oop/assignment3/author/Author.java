package sk.stuba.fei.uim.oop.assignment3.author;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.books.Book;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @OneToMany
    private List<Book> books;

}
