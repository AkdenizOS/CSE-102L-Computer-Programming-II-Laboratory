import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        runTests(library);
    }

    // This method runs several test scenarios. Do not change it.
    // When your classes are ready, run Main and check the printed output.
    static void runTests(Library library) {

        System.out.println("===== TEST 1: Add books =====");
        System.out.println("add B001 Novel:     "
                + library.addBook(new Novel("B001", "1984", "George Orwell", 1949, 9.0, 328)));
        System.out.println("add B002 Biography: "
                + library.addBook(new Biography("B002", "Diary of a Young Girl", "Anne Frank", 1947, 8.5, true)));
        System.out.println("add B003 TextBook:  "
                + library.addBook(new TextBook("B003", "Calculus Made Easy", "Silvanus Thompson", 1910, 7.8, "Math")));
        System.out.println("add B004 TextBook:  "
                + library.addBook(new TextBook("B004", "A Brief History of Time", "Stephen Hawking", 1988, 8.7, "Physics")));

        System.out.println("\n===== TEST 2: Duplicate ID =====");
        System.out.println("add B001 again:     "
                + library.addBook(new Novel("B001", "Copy Book", "Nobody", 2020, 1.0, 0)));

        System.out.println("\n===== TEST 3: Mark as read =====");
        System.out.println("mark B001:          " + library.markAsRead("B001"));
        System.out.println("mark B003:          " + library.markAsRead("B003"));
        System.out.println("mark B001 again:    " + library.markAsRead("B001"));
        System.out.println("mark B999:          " + library.markAsRead("B999"));

        System.out.println("\n===== TEST 4: isRead checks =====");
        System.out.println("isRead B001: " + library.isRead("B001"));
        System.out.println("isRead B002: " + library.isRead("B002"));
        System.out.println("isRead B999: " + library.isRead("B999"));

        System.out.println("\n===== TEST 5: List all books =====");
        Set<Book> all = library.listAllBooks();
        System.out.println("count: " + all.size());
        for (Book b : all) {
            String label = library.isRead(b.getId()) ? " [READ]" : "";
            System.out.println(b + label);
        }

        System.out.println("\n===== TEST 6: Find book by ID =====");
        System.out.println("find B002: " + library.findBook("B002"));
        System.out.println("find B999: " + library.findBook("B999"));

        System.out.println("\n===== TEST 7: Read books =====");
        Set<Book> readSet = library.listReadBooks();
        System.out.println("count: " + readSet.size());
        for (Book b : readSet) System.out.println(b);

        System.out.println("\n===== TEST 8: Unread books =====");
        Set<Book> unread = library.listUnreadBooks();
        System.out.println("count: " + unread.size());
        for (Book b : unread) System.out.println(b);

        System.out.println("\n===== TEST 9: Remove read mark =====");
        System.out.println("unmark B001:        " + library.markAsUnread("B001"));
        System.out.println("unmark B001 again:  " + library.markAsUnread("B001"));

        System.out.println("\n===== TEST 10: Books of type TextBook =====");
        Set<Book> textbooks = library.listBooksByType("TextBook");
        System.out.println("count: " + textbooks.size());
        for (Book b : textbooks) System.out.println(b);

        System.out.println("\n===== TEST 11: Books of type Comics =====");
        Set<Book> comics = library.listBooksByType("Comics");
        System.out.println("count: " + comics.size());

        System.out.println("\n===== TEST 12: Type statistics =====");
        Map<String, Integer> stats = library.typeStatistics();
        System.out.println("Novel:     " + stats.get("Novel"));
        System.out.println("Biography: " + stats.get("Biography"));
        System.out.println("TextBook:  " + stats.get("TextBook"));
    }
}
