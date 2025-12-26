package library.interfaces;

import library.model.Book;

public interface Borrowable {
    void borrow(Book book);
    void giveBack(Book book);
}
