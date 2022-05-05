package sk.stuba.fei.uim.oop.assignment3.author;

import lombok.Getter;

@Getter
public class AuthorResponse {

    private final Long id;
    private final String name;
    private final String surname;

    public AuthorResponse(Author author) {
        id = author.getId();
        name = author.getName();
        surname = author.getSurname();
    }
}
