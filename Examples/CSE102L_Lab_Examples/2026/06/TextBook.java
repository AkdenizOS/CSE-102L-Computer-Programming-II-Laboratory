public class TextBook extends Book {
    private String subject;

    public TextBook(String id, String title, String author, int year,
                    double rating, String subject) {
        super(id, title, author, year, rating);
        // TODO: This object must also remember the subject of this textbook.
    }

    public String getSubject() {
        // TODO: Give back the subject.
        return null;
    }

    @Override
    public String getType() {
        // TODO: Give back this book's type name.
        return null;
    }

    @Override
    public String toString() {
        // TODO: Give back the parent's description plus this type's extra info
        //       at the end of the same line, like " | Subject: Math".
        return null;
    }
}
