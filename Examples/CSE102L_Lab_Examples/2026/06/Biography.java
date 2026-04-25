public class Biography extends Book {
    private boolean autobiography;

    public Biography(String id, String title, String author, int year,
                     double rating, boolean autobiography) {
        super(id, title, author, year, rating);
        // TODO: This object must also remember whether the book is an autobiography.
    }

    // For boolean fields we usually start the getter with "is..." instead of "get..."
    public boolean isAutobiography() {
        // TODO: Give back the autobiography value.
        return false;
    }

    @Override
    public String getType() {
        // TODO: Give back this book's type name.
        return null;
    }

    @Override
    public String toString() {
        // TODO: Give back the parent's description plus this type's extra info
        //       at the end of the same line, like " | Autobiography: true".
        return null;
    }
}
