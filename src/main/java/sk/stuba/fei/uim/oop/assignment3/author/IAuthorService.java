package sk.stuba.fei.uim.oop.assignment3.author;

import sk.stuba.fei.uim.oop.assignment3.books.Book;

import java.util.List;

public interface IAuthorService {
    List<Author> getAll();
    Author create(AuthorRequest request);
    Author getAuthorById(Long id);
    Author updateAuthorById(Long id, AuthorRequest request);
    void deleteAuthor(Long id);
    void assignBookToNewAuthor(Author newAuthor, Book book);
}
