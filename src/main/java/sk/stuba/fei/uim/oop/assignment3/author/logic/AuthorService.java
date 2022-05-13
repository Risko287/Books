package sk.stuba.fei.uim.oop.assignment3.author.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.author.web.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.author.data.IAuthorRepository;
import sk.stuba.fei.uim.oop.assignment3.books.data.Book;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AuthorService implements IAuthorService {

    private final IAuthorRepository authorRepository;

    @Autowired
    public AuthorService(IAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    private Author saveAuthor(AuthorRequest request, Author a) {
        if (request.getName() != null)
            a.setName(request.getName());
        if (request.getSurname() != null)
            a.setSurname(request.getSurname());
        return authorRepository.save(a);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author create(AuthorRequest request) {
        return saveAuthor(request, new Author());
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Author updateAuthorById(Long id, AuthorRequest request) {
        return saveAuthor(request, getAuthorById(id));
    }

    @Override
    public void deleteAuthor(Long id) {
        Author author = getAuthorById(id);
        authorRepository.delete(author);
    }

    @Override
    public void assignBookToNewAuthor(Author newAuthor, Book book) {
        Author currentAuthor = book.getAuthor();
        currentAuthor.getBooks().remove(book);
        newAuthor.getBooks().add(book);
        authorRepository.saveAll(List.of(currentAuthor, newAuthor));
    }
}
