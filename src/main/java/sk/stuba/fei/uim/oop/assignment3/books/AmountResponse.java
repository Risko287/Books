package sk.stuba.fei.uim.oop.assignment3.books;

import lombok.Getter;

@Getter
public class AmountResponse {

    private final int amount;

    public AmountResponse(Book book) {
        amount = book.getAmount();
    }
}
