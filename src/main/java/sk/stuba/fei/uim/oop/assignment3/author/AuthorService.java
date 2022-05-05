package sk.stuba.fei.uim.oop.assignment3.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService{


    private IAuthorRepository repository;

    @Autowired
    public AuthorService(IAuthorRepository repository) {
        this.repository = repository;
        Author a1 = new Author();
        a1.setName("FERKO");
        Author a2 = new Author();
        a2.setName("JOZKO");
        this.repository.save(a1);
        this.repository.save(a2);
        this.repository.delete(a2);
    }

    @Override
    public List<Author> getAll(){
        return this.repository.findAll();
    }

    @Override
    public Author create(AuthorRequest request) {
        Author a = new Author();
        a.setName(request.getName());
        return this.repository.save(a);
    }
}
