import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    Library library;
    Book book1;
    Book book2;
    Book book3;
    Book book4;
    Student student1;

    @Before
    public void before() {
        library = new Library("Science", 5);
        book1 = new Book("Abc", "ffd", "science");
        book2 = new Book("2Abc", "2ffd", "science");
        book3 = new Book("3Abc", "3ffd", "3science");
        book4 = new Book("4Abc", "4ffd", "4science");
        student1 = new Student("Umair");
    }

    @Test
    public void addBooks() {
        library.addBooks(book1);
        library.addBooks(book2);
        library.addBooks(book3);
        library.addBooks(book4);

        assertEquals(4, library.getCollectionsCount());
    }

    @Test
    public void checkCurrentCapacity() {
        library.addBooks(book1);
        library.addBooks(book2);
        library.addBooks(book3);
        library.addBooks(book4);

        assertEquals(1, library.getCurrentCapacity());
    }

    @Test
    public void checkFullCapacity() {
        library.addBooks(book1);
        library.addBooks(book2);
        library.addBooks(book3);
        library.addBooks(book4);
        library.addBooks(book4);
        library.addBooks(book4);

        assertEquals(false, library.getCapacityStatus());
    }

    @Test
    public void borrowBooks() {
        library.addBooks(book1);
        library.addBooks(book2);
        library.addBooks(book3);
        library.addBooks(book4);

        String borrowedBook1 = book1.getTitle();
        String borrowedBook = book2.getTitle();
        student1.borrowBook(library, borrowedBook);
        assertEquals(false, library.getBookByTitle(borrowedBook));

    }

    @Test
    public void getgenreCount() {
        library.addBooks(book1);
        library.addBooks(book2);
        library.addBooks(book3);
        library.addBooks(book4);
        String genre = book1.getGenre();
        assertEquals(2, library.getGenreCount(genre));
    }


}
