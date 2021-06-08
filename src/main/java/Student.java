import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Book> studentCollections;

    public Student(String student) {
        this.name = name;
        this.studentCollections = new ArrayList<>();
    }

    public void borrowBook(Library library, String borrowedBook) {
        if (library.getBookByTitle(borrowedBook)) {
            Book book = library.removeBookFromCollection(borrowedBook);
            this.studentCollections.add(book);
        }
    }
}
