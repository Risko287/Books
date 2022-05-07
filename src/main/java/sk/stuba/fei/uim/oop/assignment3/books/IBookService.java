package sk.stuba.fei.uim.oop.assignment3.books;

import java.util.List;
import java.util.function.LongFunction;

public interface IBookService {
    List<Book> getAll();
    Book create(BookRequest request);
    Book getBookById(Long id);
    Book updateBookById(Long id, BookRequest request);
    void deleteBookById(Long id);
}
