public abstract class Book {
    protected String id;
    protected String title;
    protected String author;
    protected int year;
    protected double rating;

    public Book(String id, String title, String author, int year, double rating) {
        // TODO: When a Book object is created, it must remember the given
        //       information so the getters can hand it back later.
    }

    public String getId() {
        // TODO: Give back the book's id.
        return null;
    }

    public String getTitle() {
        // TODO: Give back the book's title.
        return null;
    }

    public String getAuthor() {
        // TODO: Give back the book's author.
        return null;
    }

    public int getYear() {
        // TODO: Give back the book's year.
        return 0;
    }

    public double getRating() {
        // TODO: Give back the book's rating.
        return 0.0;
    }

    // This method has no body because the class is abstract.
    // Every child class MUST override it and return its own type name.
    public abstract String getType();

    @Override
    public String toString() {
        // TODO: Give back a single line that fully describes this book.
        //       The line must show: id, title, year, author, rating (one decimal place)
        //       and the type name.
        //       Example output:
        //         [ID: B001] 1984 (1949) - George Orwell | Rating: 9.0 | Type: Novel
        return null;
    }
}
