package library.model;

public class Faculty extends Reader{
    public Faculty(String name) {
        super(name);
    }

    @Override
    public String whoYouAre() {
        return "Faculty";
    }
}
