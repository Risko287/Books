package sk.stuba.fei.uim.oop.assignment3.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService service;

    @Autowired
    public AuthorController(AuthorService service) {
        this.service = service;
    }


    @GetMapping()
    public List<AuthorResponse> getAllAuthors(){
        return this.service.getAll().stream().map(AuthorResponse::new).collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<AuthorResponse> addAuthor(@RequestBody AuthorRequest request){
        return new ResponseEntity<>(new AuthorResponse(this.service.create(request)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthorById(@PathVariable("id") Long id){
        try {
            service.getAuthorById(id);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new AuthorResponse(service.getAuthorById(id)),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponse> updateAuthor(@PathVariable("id") Long id, @RequestBody AuthorRequest request){
        try {
            service.getAuthorById(id);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new AuthorResponse(service.updateAuthorById(id, request)),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable("id") Long id){
        try {
            service.getAuthorById(id);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> authorNotFound(Long id){ //tu som chcel vytvorit funkciu aby som nemal duplicitny kod
        try {                                            // ale nevedel som to implementovat do tych funkcii
            service.getAuthorById(id);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
