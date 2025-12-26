package library.app;

import library.core.Library;
import library.model.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        // -------- SAMPLE DATA --------
        library.addBook(new StudyBook(0.0, "MEB", "Matematik Ders Kitabı", 0));
        library.addBook(new Magazine(150.0, "Sabah", "Haftalık Olaylar", 1));
        library.addBook(new Journal(100.0, "Bizden", "Türkiye'de Gündem", 2));

        Reader student = new Student("Emirkan");
        Reader faculty = new Faculty("Ahmet");

        library.addReader(student);
        library.addReader(faculty);

        // -------- MENU --------
        while (true) {

            System.out.println("\n--- LIBRARY SYSTEM ---");
            System.out.println("1- List all books");
            System.out.println("2- Find book by ID");
            System.out.println("3- Find book by author");
            System.out.println("4- Add new book");
            System.out.println("5- Update book");
            System.out.println("6- Remove book");
            System.out.println("7- Borrow book");
            System.out.println("8- Return book");
            System.out.println("0- Exit");

            System.out.print("Choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1 -> library.listAll();

                case 2 -> {
                    System.out.print("Book ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.println(library.findBookById(id));
                }

                case 3 -> {
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    library.listByAuthor(author);
                }

                case 4 -> {
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Price: ");
                    double price = Double.parseDouble(sc.nextLine());

                    library.addBook(new StudyBook(price, author, title, id));
                    System.out.println("Book added ✔");
                }

                case 5 -> {
                    System.out.print("Book ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("New Title: ");
                    String title = sc.nextLine();

                    System.out.print("New Author: ");
                    String author = sc.nextLine();

                    System.out.print("New Price: ");
                    double price = Double.parseDouble(sc.nextLine());

                    library.updateBook(id, title, author, price);
                    System.out.println("Book updated ✔");
                }

                case 6 -> {
                    System.out.print("Book ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    library.removeBook(id);
                    System.out.println("Book removed ✔");
                }

                case 7 -> {
                    System.out.print("Book ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    library.borrowBook(id, student);
                }

                case 8 -> {
                    System.out.print("Book ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    library.returnBook(id, student);
                }

                case 0 -> {
                    System.out.println("System closed 👋");
                    return;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
