package library.model;

import library.enums.BookStatus;

public abstract class Book {

    private Integer id;
    private String title;
    private String author;
    private Double price;
    private BookStatus status = BookStatus.AVAILABLE;

    public Book(Double price, String author, String title, Integer id) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // 🔥 Polymorphism point
    public abstract String getType();

    public void borrow() {
        status = BookStatus.BORROWED;
    }

    public void giveBack() {
        status = BookStatus.AVAILABLE;
    }

    public boolean isAvailable() {
        return status == BookStatus.AVAILABLE;
    }

    // -------- GETTERS --------

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }

    // -------- SETTERS --------

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", type=" + getType() +
                '}';
    }
}
