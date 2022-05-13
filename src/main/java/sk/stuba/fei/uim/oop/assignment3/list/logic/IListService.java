package sk.stuba.fei.uim.oop.assignment3.list.logic;

import sk.stuba.fei.uim.oop.assignment3.list.data.List;
import sk.stuba.fei.uim.oop.assignment3.list.web.IdRequest;

public interface IListService {

    java.util.List<List> getAllLists();
    List createList();
    List getListById(Long id);
    void deleteListById(Long id);

    List addBookToList(Long id, IdRequest request);
    void removeBookFromList(Long id, IdRequest request);
    void lendList(Long id);

}
