package sk.stuba.fei.uim.oop.assignment3.books;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    Book create(BookRequest request);
    Book getBookById(Long id);
    Book updateBookById(Long id, BookRequest request);
    void deleteBookById(Long id);

    Book updateBookAmount(Long id, BookRequest request);
}
