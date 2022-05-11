package sk.stuba.fei.uim.oop.assignment3.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.Author;
import sk.stuba.fei.uim.oop.assignment3.author.AuthorService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BookService implements IBookService{

    private final IBookRepository repository;
    private final AuthorService authorService;

    @Autowired
    public BookService(IBookRepository repository, AuthorService authorService) {
        this.repository = repository;
        this.authorService = authorService;
        /*
        Book book1 = new Book();
        book1.setName("psicek a macicka");
        book1.setDescription("rozpravka");
        book1.setAuthor(authorService.getAuthorById(1L));
        this.authorService.getAuthorById(1L).getBooks().add(book1);
        book1.setAmount(50L);
        book1.setPages(400);
        book1.setLendCount(10L);
        this.repository.save(book1);
         */
        }


    private Book saveBook(BookRequest request, Book book) {
        if (request.getName() != null) {
            book.setName(request.getName());
        }
        if (request.getDescription() != null) {
            book.setDescription(request.getDescription());
        }
        if (request.getPages() != 0) {
            book.setPages(request.getPages());
        }
        return repository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public Book create(BookRequest request) {
        Book book = new Book();
        authorService.getAuthorById(request.getAuthor()).getBooks().add(book);
        book.setAuthor(authorService.getAuthorById(request.getAuthor()));
        book.setAmount(request.getAmount());
        book.setLendCount(request.getLendCount());
        return saveBook(request, book);
    }

    @Override
    public Book getBookById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Book updateBookById(Long id, BookRequest request) {
        Book book = getBookById(id);

        if (request.getAuthor() != 0) {
            Author author = authorService.getAuthorById(request.getAuthor());
            if (book.getAuthor().getId() != request.getAuthor()) {
                authorService.assignBookToNewAuthor(author, book);
                book.setAuthor(author);
            }
        }

        return saveBook(request, book);
    }

    @Override
    public void deleteBookById(Long id) {
        Book book = getBookById(id);
        book.getAuthor().getBooks().remove(book);
        repository.delete(book);
    }

    @Override
    public int getBookAmount(Long id) {
        return getBookById(id).getAmount();
    }

    @Override
    public int updateBookAmount(Long id, Amount request) {
        Book book = getBookById(id);
        int amount = book.getAmount() + request.getAmount();
        //amount += request.getAmount();
        book.setAmount(amount);
        repository.save(book);

        return amount;
    }

    @Override
    public int getBookLendCount(Long id) {
        return getBookById(id).getLendCount();
    }
}
