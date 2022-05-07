package sk.stuba.fei.uim.oop.assignment3.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        /////////////this.repository.delete(a2);
    }

    @Override
    public List<Author> getAll() {
        return repository.findAll();
    }

    @Override
    public Author create(AuthorRequest request) {
        Author a = new Author();
        a.setName(request.getName());
        a.setSurname(request.getSurname());
        return repository.save(a);
    }

    @Override
    public Author getAuthorById(Long id) {
        /*
        if (!repository.existsById(id)){
            throw new EntityNotFoundException();  //moze byt takto?
        }   return repository.findAuthorById(id);
         */
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Author updateAuthorById(Long id, AuthorRequest request) {
        Author update = repository.findAuthorById(id);
        update.setName(request.getName());
        update.setSurname(request.getSurname());
        return repository.save(update);
    }

    @Override
    public void deleteAuthor(Long id) {
        repository.deleteById(id);
    }
}
