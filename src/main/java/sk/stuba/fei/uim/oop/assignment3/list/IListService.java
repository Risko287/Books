package sk.stuba.fei.uim.oop.assignment3.list;

public interface IListService {

    java.util.List<List> getAllLists();
    List createList(ListRequest request);
    List getListById(Long id);
    void deleteListById(Long id);

}
