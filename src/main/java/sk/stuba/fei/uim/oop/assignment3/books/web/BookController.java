package sk.stuba.fei.uim.oop.assignment3.books.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.books.logic.BookService;

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
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/amount")
    public ResponseEntity<Amount> getBookAmount(@PathVariable Long id){
        try {
            return new ResponseEntity<>(new Amount(service.getBookAmount(id)),HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/amount")
    public ResponseEntity<Amount> addBookAmount(@PathVariable Long id, @RequestBody Amount request){
        try {
            return new ResponseEntity<>(new Amount(service.updateBookAmount(id, request)),HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/lendCount")
    public ResponseEntity<Amount> getBookLendCount(@PathVariable Long id){
        try {
            return new ResponseEntity<>(new Amount(service.getBookLendCount(id)),HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
