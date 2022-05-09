package sk.stuba.fei.uim.oop.assignment3.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BookService implements IBookService{

    private final IBookRepository repository;

    @Autowired
    public BookService(IBookRepository repository) {
        this.repository = repository;
        Book book1 = new Book();
        book1.setName("psicek a macicka");
        book1.setDescription("rozpravka");
        book1.setAuthor(1L);
        book1.setAmount(50L);
        book1.setPages(400);
        book1.setLendCount(10L);
        this.repository.save(book1);
    }

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public Book create(BookRequest request) {
        return saveBook(request, new Book());
    }

    @Override
    public Book getBookById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Book updateBookById(Long id, BookRequest request) {
        /*
        if (!repository.existsById(id)){
            throw new EntityNotFoundException();
        }
        Book b = repository.findById(id).get(); //da sa aby mi to nesvietilo bez toho aby som pouzil optional?
         */
        return saveBook(request, getBookById(id));
    }

    private Book saveBook(BookRequest request, Book book) { //toto mi vytvoril sam IntelliJ :D
        book.setName(request.getName());
        book.setDescription(request.getDescription());
        book.setAuthor(request.getAuthor());
        book.setPages(request.getPages());
        book.setAmount(request.getAmount());
        book.setLendCount(request.getLendCount());
        return repository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        if (!repository.existsById(id)){
            throw new EntityNotFoundException();
        }
        repository.deleteById(id);
    }
}
