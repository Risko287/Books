package sk.stuba.fei.uim.oop.assignment3.list.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.uim.oop.assignment3.list.logic.ListService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/list")
public class ListController {

    private final ListService service;

    @Autowired
    public ListController(ListService service) {
        this.service = service;
    }

    @GetMapping
    public List<ListResponse> getAllLists(){
        return service.getAllLists().stream().map(ListResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<ListResponse> createList(){
        return new ResponseEntity<>(new ListResponse(service.createList()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListResponse> getList(@PathVariable Long id){
        return new ResponseEntity<>(new ListResponse(service.getListById(id)),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteList(@PathVariable("id") Long id){
        service.deleteListById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}/add")
    public ResponseEntity<ListResponse> addBookToList(@PathVariable Long id, @RequestBody IdRequest request){
        return new ResponseEntity<>(new ListResponse(service.addBookToList(id, request)),HttpStatus.OK);
    }

    @DeleteMapping("/{id}/remove")
    public ResponseEntity<Void> removeBookFromList(@PathVariable("id") Long id,  @RequestBody IdRequest request){
        service.removeBookFromList(id, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/lend")
    public ResponseEntity<Void> lendList(@PathVariable Long id){
        service.lendList(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

