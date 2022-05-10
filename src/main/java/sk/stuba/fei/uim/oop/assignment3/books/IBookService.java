package sk.stuba.fei.uim.oop.assignment3.books;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    Book create(BookRequest request);
    Book getBookById(Long id);
    Book updateBookById(Long id, BookRequest request);
    void deleteBookById(Long id);

    int getBookAmount(Long id);
    int updateBookAmount(Long id, Amount request);
    int getBookLendCount(Long id);
}
