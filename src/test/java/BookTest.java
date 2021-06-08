import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    Book book;

    @Before
    public void before() {

        book = new Book("Harry potter", "J K  Rolling", "Fantisy");
    }
    @Test

    public void getBookTitle (){

        assertEquals("Harry potter",book.getTitle());
    }


}
