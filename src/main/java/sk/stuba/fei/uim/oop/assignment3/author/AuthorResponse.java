package sk.stuba.fei.uim.oop.assignment3.author;

import lombok.Getter;

@Getter
public class AuthorResponse {

    private Long id;
    private String name;

    public AuthorResponse(Author author) {
        this.id = author.getId();
        this.name = author.getName();
    }
}
