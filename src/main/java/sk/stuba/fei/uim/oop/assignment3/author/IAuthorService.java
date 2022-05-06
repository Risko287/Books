package sk.stuba.fei.uim.oop.assignment3.author;

import java.util.List;

public interface IAuthorService {
    List<Author> getAll();
    Author create(AuthorRequest request);
    Author getAuthorById(Long id);
    Author updateAuthorById(Long id, AuthorRequest request);
    void deleteAuthor(Long id); //rozmyslal som aky tu dam typ ale nic mi nenapadlo tak som dal void :D

}
