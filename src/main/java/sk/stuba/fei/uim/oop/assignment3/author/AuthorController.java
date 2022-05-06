package sk.stuba.fei.uim.oop.assignment3.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService service;


    @GetMapping()
    public List<AuthorResponse> getAllAuthors(){
        return this.service.getAll().stream().map(AuthorResponse::new).collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<AuthorResponse> addAuthor(@RequestBody AuthorRequest request){
        return new ResponseEntity<>(new AuthorResponse(this.service.create(request)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")   //pri vsetkych tychto idckach potrebujem osetrit ci to id existuje
    public AuthorResponse getAuthorById(@PathVariable("id") Long id){
        return new AuthorResponse(service.getAuthorById(id));
    }

    @PutMapping("/{id}")
    public AuthorResponse updateAuthor(@PathVariable("id") Long id, @RequestBody AuthorRequest request){
        return new AuthorResponse(service.updateAuthorById(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuthor(@PathVariable("id") Long id){   //neviem preco mi toto tak divne svieti
        service.deleteAuthor(id);
        return new ResponseEntity(HttpStatus.OK);  //aj toto
    }
}
