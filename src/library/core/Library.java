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

    // ---------- ADD ----------
    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    // ---------- FIND ----------
    public Book findBookById(int id) {
        return books.get(id);
    }

    public void findByTitle(String title) {
        books.values().stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .forEach(System.out::println);
    }

    public void listByAuthor(String author) {
        books.values().stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .forEach(System.out::println);
    }

    public void listByType(String type) {
        books.values().stream()
                .filter(b -> b.getType().equalsIgnoreCase(type))
                .forEach(System.out::println);
    }

    // ---------- UPDATE ----------
    public void updateBook(int id, String newTitle, String newAuthor, double newPrice) {
        Book book = books.get(id);
        if (book != null && book.isAvailable()) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            book.setPrice(newPrice);
        }
    }

    // ---------- REMOVE ----------
    public void removeBook(int id) {
        Book book = books.get(id);
        if (book != null && book.isAvailable()) {
            books.remove(id);
        }
    }

    // ---------- BORROW ----------
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

    // ---------- RETURN ----------
    public void returnBook(int id, Reader reader) {
        Book book = books.get(id);

        if (book != null && borrowedBooks.get(book) == reader) {
            book.giveBack();
            reader.giveBack(book);
            borrowedBooks.remove(book);
            Invoice.refund(book.getPrice());
        }
    }

    // ---------- LIST ----------
    public void listAll() {
        books.values().forEach(System.out::println);
    }
}
