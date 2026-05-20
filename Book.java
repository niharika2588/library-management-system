// Book.java - Represents a Book in the library
public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // by default book is available
    }

    // Getters
    public int getId()          { return id; }
    public String getTitle()    { return title; }
    public String getAuthor()   { return author; }
    public boolean isAvailable(){ return isAvailable; }

    // Setters
    public void setAvailable(boolean available) { this.isAvailable = available; }

    @Override
    public String toString() {
        return String.format("ID: %d | Title: %-30s | Author: %-20s | Status: %s",
                id, title, author, isAvailable ? "Available" : "Borrowed");
    }
}
