package sk.stuba.fei.uim.oop.assignment3.books.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.uim.oop.assignment3.books.logic.BookService;

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
        return new ResponseEntity<>(new BookResponse(service.getBookById(id)),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable("id") Long id, @RequestBody BookRequest request){
        return new ResponseEntity<>(new BookResponse(service.updateBookById(id, request)),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id){
        service.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/amount")
    public ResponseEntity<Amount> getBookAmount(@PathVariable Long id){
        return new ResponseEntity<>(new Amount(service.getBookAmount(id)),HttpStatus.OK);
    }

    @PostMapping("/{id}/amount")
    public ResponseEntity<Amount> addBookAmount(@PathVariable Long id, @RequestBody Amount request){
        return new ResponseEntity<>(new Amount(service.updateBookAmount(id, request)),HttpStatus.OK);
    }

    @GetMapping("/{id}/lendCount")
    public ResponseEntity<Amount> getBookLendCount(@PathVariable Long id){
        return new ResponseEntity<>(new Amount(service.getBookLendCount(id)),HttpStatus.OK);
    }
}
