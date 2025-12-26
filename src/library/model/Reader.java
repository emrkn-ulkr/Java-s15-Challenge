package library.model;

import library.interfaces.Borrowable;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person implements Borrowable {
private List<Book> books = new ArrayList<>();
private static final Integer LIMIT = 5;


    public List<Book> getBooks(){
        return books;
    }

    public Boolean canBorrow(){
        return books.size()<LIMIT;
    }

    public Reader(String name) {
        super(name);
    }

    @Override
    public void borrow(Book book){
        books.add(book);
    }

    @Override
    public void giveBack(Book book){
        books.remove(book);
    }

    @Override
    public String whoYouAre()
    {
        return "Reader";
    }
}

