package sk.stuba.fei.uim.oop.assignment3.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ListService implements IListService{

    private final IListRepository repository;

    @Autowired
    public ListService(IListRepository repository) {
        this.repository = repository;
    }

    @Override
    public java.util.List<List> getAllLists() {
        return repository.findAll();
    }

    @Override
    public List createList(ListRequest request) {
        List list = new List();
        list.setLendingList(request.getLendingList());
        list.setLended(request.isLended());
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
