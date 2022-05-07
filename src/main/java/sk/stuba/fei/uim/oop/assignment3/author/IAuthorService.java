package sk.stuba.fei.uim.oop.assignment3.author;

import java.util.List;

public interface IAuthorService {
    List<Author> getAll();
    Author create(AuthorRequest request);
    Object getAuthorById(Long id);
    Author updateAuthorById(Long id, AuthorRequest request);
    void deleteAuthor(Long id);

}
