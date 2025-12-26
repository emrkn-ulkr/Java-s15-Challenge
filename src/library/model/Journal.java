package library.model;

public class Journal extends Book{
    public Journal(Double price, String author, String title, Integer id) {
        super(price, author, title, id);
    }
    public String getType(){
        return "Journal";
    }
}
