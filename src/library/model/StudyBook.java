package library.model;

public class StudyBook extends Book {
    public StudyBook(Double price, String author, String title, Integer id) {
        super(price, author, title, id);
    }
    public String getType(){
        return "StudyBook";
    }
}
