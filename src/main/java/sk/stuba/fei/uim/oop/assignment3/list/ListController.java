package sk.stuba.fei.uim.oop.assignment3.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.books.Amount;

import javax.persistence.EntityNotFoundException;
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
        try {
            return new ResponseEntity<>(new ListResponse(service.getListById(id)),HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteList(@PathVariable("id") Long id){
        try {
            service.deleteListById(id);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}/add")
    public ResponseEntity<ListResponse> addBookToList(@PathVariable Long id, @RequestBody IdRequest request){
        try {
            return new ResponseEntity<>(new ListResponse(service.addBookToList(id, request)),HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}/remove")
    public ResponseEntity<Void> removeBookFromList(@PathVariable("id") Long id,  @RequestBody IdRequest request){
        try {
            service.removeBookFromList(id, request);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/lend")
    public ResponseEntity<Void> lendList(@PathVariable Long id){
        try {
            service.lendList(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

