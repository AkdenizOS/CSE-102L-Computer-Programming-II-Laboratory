public class Novel extends Book {
    private int pageCount;

    public Novel(String id, String title, String author, int year,
                 double rating, int pageCount) {
        super(id, title, author, year, rating);
        // TODO: This object must also remember how many pages this novel has.
    }

    public int getPageCount() {
        // TODO: Give back the page count.
        return 0;
    }

    @Override
    public String getType() {
        // TODO: Give back this book's type name.
        return null;
    }

    @Override
    public String toString() {
        // TODO: Give back the parent's description plus this type's extra info
        //       at the end of the same line, like " | Pages: 328".
        return null;
    }
}
