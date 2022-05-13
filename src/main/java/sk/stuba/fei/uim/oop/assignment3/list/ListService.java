package sk.stuba.fei.uim.oop.assignment3.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.books.Book;
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
        List list = getListById(id);
        if (list.isLended()) {
            for (int i = 0; i < list.getLendingList().size(); i++) {
                int lendCount = list.getLendingList().get(i).getLendCount();
                list.getLendingList().get(i).setLendCount(lendCount - 1);
            }
        }
        repository.delete(list);
    }

    @Override
    public List addBookToList(Long id, IdRequest request) {
        List list = getListById(id);
        Book book = bookService.getBookById(request.getId());
        if (list.isLended() || list.getLendingList().contains(book)) throw new IllegalStateException();
        list.getLendingList().add(book);
        return repository.save(list);
    }

    @Override
    public void removeBookFromList(Long id, IdRequest request) {
        List list = getListById(id);
        Book book = bookService.getBookById(request.getId());
        list.getLendingList().remove(book);
        repository.save(list);
    }

    @Override
    public void lendList(Long id) {
        List list = getListById(id);
        if (list.isLended()) throw new IllegalStateException();
        for (int i = 0; i < list.getLendingList().size(); i++) {
            int lendCount = list.getLendingList().get(i).getLendCount();
            list.getLendingList().get(i).setLendCount(lendCount + 1);
        }
        list.setLended(true);
        repository.save(list);
    }
}
