// Library.java - Core logic: manages books and members
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    private int bookIdCounter;
    private int memberIdCounter;

    // Constructor
    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        bookIdCounter = 1;
        memberIdCounter = 1;

        // Add some default books
        addBook("The Alchemist", "Paulo Coelho");
        addBook("Clean Code", "Robert C. Martin");
        addBook("Java: The Complete Reference", "Herbert Schildt");
        addBook("Introduction to Algorithms", "Thomas H. Cormen");
        addBook("Harry Potter and the Sorcerer's Stone", "J.K. Rowling");
    }

    // -------- BOOK OPERATIONS --------

    public void addBook(String title, String author) {
        books.add(new Book(bookIdCounter++, title, author));
        System.out.println("Book added successfully: " + title);
    }

    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("\n========== ALL BOOKS ==========");
        for (Book b : books) {
            System.out.println(b);
        }
        System.out.println("================================\n");
    }

    public void searchBook(String keyword) {
        System.out.println("\n--- Search Results ---");
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                b.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) System.out.println("No book found with keyword: " + keyword);
        System.out.println();
    }

    public void deleteBook(int bookId) {
        for (Book b : books) {
            if (b.getId() == bookId) {
                if (!b.isAvailable()) {
                    System.out.println("Cannot delete! Book is currently borrowed.");
                    return;
                }
                books.remove(b);
                System.out.println("Book deleted: " + b.getTitle());
                return;
            }
        }
        System.out.println("Book ID not found.");
    }

    // -------- MEMBER OPERATIONS --------

    public void addMember(String name) {
        members.add(new Member(memberIdCounter++, name));
        System.out.println("Member registered: " + name);
    }

    public void viewAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }
        System.out.println("\n========== ALL MEMBERS ==========");
        for (Member m : members) {
            System.out.println(m);
        }
        System.out.println("==================================\n");
    }

    // -------- BORROW & RETURN --------

    public void borrowBook(int memberId, int bookId) {
        Member member = findMember(memberId);
        Book book = findBook(bookId);

        if (member == null) { System.out.println("Member not found."); return; }
        if (book == null)   { System.out.println("Book not found."); return; }

        if (member.getBorrowedBookTitle() != null) {
            System.out.println(member.getName() + " already has a borrowed book. Please return it first.");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("Sorry! \"" + book.getTitle() + "\" is already borrowed.");
            return;
        }

        book.setAvailable(false);
        member.setBorrowedBookTitle(book.getTitle());
        System.out.println("Success! \"" + book.getTitle() + "\" borrowed by " + member.getName());
    }

    public void returnBook(int memberId, int bookId) {
        Member member = findMember(memberId);
        Book book = findBook(bookId);

        if (member == null) { System.out.println("Member not found."); return; }
        if (book == null)   { System.out.println("Book not found."); return; }

        if (member.getBorrowedBookTitle() == null ||
            !member.getBorrowedBookTitle().equals(book.getTitle())) {
            System.out.println("This member did not borrow this book.");
            return;
        }

        book.setAvailable(true);
        member.setBorrowedBookTitle(null);
        System.out.println("Book returned successfully: \"" + book.getTitle() + "\" by " + member.getName());
    }

    // -------- HELPERS --------

    private Book findBook(int id) {
        for (Book b : books)
            if (b.getId() == id) return b;
        return null;
    }

    private Member findMember(int id) {
        for (Member m : members)
            if (m.getMemberId() == id) return m;
        return null;
    }
}
