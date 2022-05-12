package sk.stuba.fei.uim.oop.assignment3.list;

public interface IListService {

    java.util.List<List> getAllLists();
    List createList();
    List getListById(Long id);
    void deleteListById(Long id);

    Long addBookToList(Long id, IdRequest request);

}
