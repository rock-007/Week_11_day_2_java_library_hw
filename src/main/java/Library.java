import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private String name;
    private int capacity;
    private ArrayList<Book> collections;
    private HashMap<String, Integer> trackGenere;

    public Library(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        collections = new ArrayList<>();
        trackGenere = new HashMap<>();
    }

    public void addBooks(Book book) {
        if (capacity > 0) {
            collections.add(book);
            String genre = book.getGenre();
            if (!trackGenere.containsKey(genre)) {
                trackGenere.put(genre, 0);
            }
            int currentCount = trackGenere.get(genre);
            trackGenere.put(genre, currentCount+1);
            capacity--;
        }
    }

    public int getCollectionsCount() {
        return this.collections.size();
    }

    public int getCurrentCapacity() {
        return this.capacity;
    }

    public Boolean getCapacityStatus() {
        return capacity > 0;
    }

    public boolean getBookByTitle(String borrowedBook) {
        boolean search = false;
        for (int i = 0; i < collections.size(); i++) {
            if (collections.get(i).getTitle() == borrowedBook) {
                search = true;
                break;
            }

        }
        return search;
    }

    public Book searchBookByTitle(String borrowedBook) {
        int bookIndexInCollection = getIndexInCollection(borrowedBook);
        return collections.get(bookIndexInCollection);
    }

    private int getIndexInCollection(String borrowedBook) {
        int index = -1;

        for (int i = 0; i < collections.size(); i++) {
            if (collections.get(i).getTitle() == borrowedBook) {
                index = i;
                break;
            }
        }
        return index;

    }

    public Book removeBookFromCollection(String borrowedBook) {
        int bookIndexInCollection = getIndexInCollection(borrowedBook);
        int currentCount = trackGenere.get(borrowedBook);
        trackGenere.put(borrowedBook, currentCount++);
        return collections.remove(bookIndexInCollection);
    }

    public int getGenreCount(String genre) {
        System.out.println(genre);
        return trackGenere.get(genre);
    }
}
