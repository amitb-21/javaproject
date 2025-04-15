public class Book {
    int id;
    String title;
    String author;
    boolean available;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String toString() {
        return id + " - " + title + " (" + (available ? "Available" : "Issued") + ")";
    }
}
