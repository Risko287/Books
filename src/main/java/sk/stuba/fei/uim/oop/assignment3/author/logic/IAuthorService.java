package sk.stuba.fei.uim.oop.assignment3.author.logic;

import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.author.web.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.books.data.Book;

import java.util.List;

public interface IAuthorService {

    List<Author> getAll();
    Author create(AuthorRequest request);
    Author getAuthorById(Long id);
    Author updateAuthorById(Long id, AuthorRequest request);
    void deleteAuthor(Long id);
    void assignBookToNewAuthor(Author newAuthor, Book book);
}
