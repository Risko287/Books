package sk.stuba.fei.uim.oop.assignment3.books;

import lombok.Getter;

@Getter
public class LendCountResponse {

    private final int amount;

    public LendCountResponse(Book book) {
        amount = book.getLendCount();
    }
}
