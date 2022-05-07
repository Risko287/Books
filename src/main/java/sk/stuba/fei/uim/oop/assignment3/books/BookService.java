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
    }

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public Book create(BookRequest request) {
        Book b = new Book();
        return getBook(request, b);
    }

    @Override
    public Book getBookById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Book updateBookById(Long id, BookRequest request) {
        if (!repository.existsById(id)){
            throw new EntityNotFoundException();
        }
        Book b = repository.findById(id).get(); //da sa aby mi to nesvietilo bez toho aby som pouzil optional?
        return getBook(request, b);
    }

    private Book getBook(BookRequest request, Book b) { //toto mi vytvoril sam IntelliJ :D
        b.setName(request.getName());
        b.setDescription(request.getDescription());
        b.setAuthor(request.getAuthor());
        b.setPages(request.getPages());
        b.setAmount(request.getAmount());
        b.setLendCount(request.getLendCount());
        return repository.save(b);
    }

    @Override
    public void deleteBookById(Long id) {
        if (!repository.existsById(id)){
            throw new EntityNotFoundException();
        }
        repository.deleteById(id);
    }
}
