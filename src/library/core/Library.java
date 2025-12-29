package library.core;

import library.model.Book;
import library.model.Reader;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Library {

    private Map<Integer, Book> books = new HashMap<>();
    private Set<Reader> readers = new HashSet<>();
    private Map<Book, Reader> borrowedBooks = new HashMap<>();

  
    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    public Book findBookById(int id) {
        return books.get(id);
    }

    public void findByTitle(String title) {
        for (Book b : books.values()) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println(b);
            }
        }
    }

    public void listByAuthor(String author) {
        for (Book b : books.values()) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(b);
            }
        }
    }

    public void listByType(String type) {
        for (Book b : books.values()) {
            if (b.getType().equalsIgnoreCase(type)) {
                System.out.println(b);
            }
        }
    }


    public void updateBook(int id, String newTitle, String newAuthor, double newPrice) {
        Book book = books.get(id);
        if (book != null && book.isAvailable()) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            book.setPrice(newPrice);
        }
    }

    public void removeBook(int id) {
        Book book = books.get(id);
        if (book != null && book.isAvailable()) {
            books.remove(id);
        }
    }


    public void borrowBook(int id, Reader reader) {
        Book book = books.get(id);

        if (book != null
                && book.isAvailable()
                && reader.canBorrow()
                && !borrowedBooks.containsKey(book)) {

            book.borrow();
            reader.borrow(book);
            borrowedBooks.put(book, reader);
            Invoice.pay(book.getPrice());
        }
    }


    public void returnBook(int id, Reader reader) {
        Book book = books.get(id);

        if (book != null && borrowedBooks.get(book) == reader) {
            book.giveBack();
            reader.giveBack(book);
            borrowedBooks.remove(book);
            Invoice.refund(book.getPrice());
        }
    }

    
    public void listAll() {
        books.values().forEach(System.out::println);
    }
}
