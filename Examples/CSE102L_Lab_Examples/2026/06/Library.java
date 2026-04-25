import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Library {
    private Map<String, Book> books = new HashMap<>();
    private Set<String> readBooks = new HashSet<>();
    private Map<String, Set<String>> typeIndex = new HashMap<>();

    public boolean addBook(Book b) {
        // TODO: Add the book to the collection and keep typeIndex in sync
        //       so that later queries by type can find this book.
        //       If another book already has the same ID, do NOT add it.
        //       Give back true when the book is added, false when the ID is a duplicate.
        return false;
    }

    public Book findBook(String id) {
        // TODO: Give back the book with this ID. Give back null if no book has it.
        return null;
    }

    public boolean markAsRead(String id) {
        // TODO: Mark the book as read.
        //       Give back true only when the mark was newly added.
        //       Give back false if the book does not exist OR it was already read.
        return false;
    }

    public boolean markAsUnread(String id) {
        // TODO: Remove the read mark from the book.
        //       Give back true when a mark was actually removed.
        //       Give back false when the book was not marked as read.
        return false;
    }

    public boolean isRead(String id) {
        // TODO: Give back true if the book with this ID is currently marked
        //       as read, false otherwise.
        return false;
    }

    public Set<Book> listAllBooks() {
        // TODO: Give back a Set that contains every book in the collection.
        //       If the collection is empty, give back an empty set.
        return new HashSet<>();
    }

    public Set<Book> listReadBooks() {
        // TODO: Give back a Set that contains only the read books.
        //       If nothing is read, give back an empty set.
        return new HashSet<>();
    }

    public Set<Book> listUnreadBooks() {
        // TODO: Give back a Set that contains only the books that are NOT read.
        //       If every book is read, give back an empty set.
        return new HashSet<>();
    }

    public Set<Book> listBooksByType(String type) {
        // TODO: Give back a Set that contains every book of the given type.
        //       If no book exists for that type, give back an empty set.
        return new HashSet<>();
    }

    public Map<String, Integer> typeStatistics() {
        // TODO: Give back a Map that pairs every type name with the number of
        //       books in that type. Example: {"Novel"=1, "Biography"=1, "TextBook"=2}.
        //       If the collection is empty, give back an empty map.
        return new HashMap<>();
    }
}
