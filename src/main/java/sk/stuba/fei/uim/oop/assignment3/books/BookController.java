package sk.stuba.fei.uim.oop.assignment3.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<BookResponse> getAllBooks(){
        return service.getAll().stream().map(BookResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequest request){
        return new ResponseEntity<>(new BookResponse(service.create(request)), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable Long id){
        try {
            return new ResponseEntity<>(new BookResponse(service.getBookById(id)),HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable("id") Long id, @RequestBody BookRequest request){
        try {
            return new ResponseEntity<>(new BookResponse(service.updateBookById(id, request)),HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id){
        try {
            service.deleteBookById(id);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/amount")
    public ResponseEntity<Integer> getBookAmount(@PathVariable Long id){
        try {
            return new ResponseEntity<>(service.getBookById(id).getAmount(),HttpStatus.OK); //toto je dobre? co sa tyka struktury
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/amount")
    public ResponseEntity<BookResponse> addBookAmount(@PathVariable Long id, @RequestBody BookRequest request){
        try {
            return new ResponseEntity<>(new BookResponse(service.updateBookAmount(id, request)),HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/lendCount")
    public ResponseEntity<Integer> getBookLendCount(@PathVariable Long id){
        try {
            return new ResponseEntity<>(service.getBookById(id).getLendCount(),HttpStatus.OK); //toto je dobre? co sa tyka struktury
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
