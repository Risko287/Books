package sk.stuba.fei.uim.oop.assignment3.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.books.BookService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service
public class ListService implements IListService{

    private final IListRepository repository;
    private final BookService bookService;

    @Autowired
    public ListService(IListRepository repository, BookService bookService) {
        this.repository = repository;
        this.bookService = bookService;
    }

    @Override
    public java.util.List<List> getAllLists() {
        return repository.findAll();
    }

    @Override
    public List createList() {
        List list = new List();
        list.setLended(false);
        list.setLendingList(new ArrayList<>());
        return repository.save(list);
    }

    @Override
    public List getListById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteListById(Long id) {
        repository.deleteById(id);
    }

}
