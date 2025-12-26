package library.model;

public class Student extends Reader{
    public Student(String name) {
        super(name);
    }

    @Override
    public String whoYouAre(){
        return "Student";
    }
}
