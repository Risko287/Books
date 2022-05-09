package sk.stuba.fei.uim.oop.assignment3.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.books.Book;
import sk.stuba.fei.uim.oop.assignment3.books.BookService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService implements IAuthorService {

    private final IAuthorRepository repository;

    @Autowired
    public AuthorService(IAuthorRepository repository) {
        this.repository = repository;
        //////////////////////////////
        Author a1 = new Author();
        a1.setName("FERKO");
        a1.setSurname("MRKVICKA");
        Author a2 = new Author();
        a2.setName("jozko");
        a2.setSurname("baci");
        this.repository.save(a1);
        this.repository.save(a2);
        /////////////////////////////
    }

    private Author saveAuthor(AuthorRequest request, Author a) {
        a.setName(request.getName());
        a.setSurname(request.getSurname());
        return repository.save(a);
    }

    @Override
    public List<Author> getAll() {
        return repository.findAll();
    }

    @Override
    public Author create(AuthorRequest request) {
        return saveAuthor(request, new Author());
    }

    @Override
    public Author getAuthorById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Author updateAuthorById(Long id, AuthorRequest request) {
        return saveAuthor(request, getAuthorById(id));
    }

    @Override
    public void deleteAuthor(Long id) {
        Author author = getAuthorById(id);
        author.getBooks().clear();
        repository.save(author);
        repository.delete(author);
    }
}
