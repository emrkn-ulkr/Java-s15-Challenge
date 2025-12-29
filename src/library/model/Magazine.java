package library.model;

public class Magazine extends Book{
    public Magazine(Double price, String author, String title, Integer id) {
        super(price, author, title, id);
    }
    @Override
    public String getType(){
        return "Magazine";
    }
}
