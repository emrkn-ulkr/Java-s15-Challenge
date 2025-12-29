package library.app;

import library.core.Library;
import library.model.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        Scanner sc = new Scanner(System.in);


        library.addBook(new StudyBook(0.0, "MEB", "Matematik Ders Kitabı", 0));
        library.addBook(new Magazine(150.0, "Sabah", "Haftalık Olaylar", 1));
        library.addBook(new Journal(100.0, "Bizden", "Türkiye'de Gündem", 2));

        Reader student = new Student("Emirkan");
        Reader faculty = new Faculty("Öğr Grv Ebru");

        library.addReader(student);
        library.addReader(faculty);

        // -------- Menu Kismi --------
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

                // 1 Tüm kitapları listeler
                case 1:
                    library.listAll();
                    break;

                // 2 ID ile kitap bulur ve ekrana yazar
                case 2:
                    System.out.print("Book ID: ");
                    int findId = Integer.parseInt(sc.nextLine());
                    Book found = library.findBookById(findId);

                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;

                // 3 Yazara göre kitapları listeler
                case 3:
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    library.listByAuthor(author);
                    break;

                // 4 Yeni kitap ekler
                case 4:
                    System.out.print("ID: ");
                    int newId = Integer.parseInt(sc.nextLine());

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String newAuthor = sc.nextLine();

                    System.out.print("Price: ");
                    double price = Double.parseDouble(sc.nextLine());

                    library.addBook(new StudyBook(price, newAuthor, title, newId));
                    System.out.println("Book added ");
                    break;

                // 5 Var olan kitabın bilgilerini günceller
                case 5:
                    System.out.print("Book ID: ");
                    int updateId = Integer.parseInt(sc.nextLine());

                    System.out.print("New Title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("New Author: ");
                    String updateAuthor = sc.nextLine();

                    System.out.print("New Price: ");
                    double newPrice = Double.parseDouble(sc.nextLine());

                    library.updateBook(updateId, newTitle, updateAuthor, newPrice);
                    System.out.println("Book updated ");
                    break;

                // 6 Kitabı sistemden siler (ödünçte değilse)
                case 6:
                    System.out.print("Book ID: ");
                    int removeId = Integer.parseInt(sc.nextLine());
                    library.removeBook(removeId);
                    System.out.println("Book removed ✔");
                    break;

                // 7 Kitabı ödünç verir
                case 7:
                    System.out.print("Book ID: ");
                    int borrowId = Integer.parseInt(sc.nextLine());
                    library.borrowBook(borrowId, student);
                    break;

                // 8 Ödünç alınan kitabı iade eder
                case 8:
                    System.out.print("Book ID: ");
                    int returnId = Integer.parseInt(sc.nextLine());
                    library.returnBook(returnId, student);
                    break;

                // 0 Programı kapatır
                case 0:
                    System.out.println("System closed ");
                    sc.close();
                    return;

                // Geçersiz seçim
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
