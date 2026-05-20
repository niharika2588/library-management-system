// Member.java - Represents a Library Member
public class Member {
    private int memberId;
    private String name;
    private String borrowedBookTitle; // tracks which book they borrowed

    // Constructor
    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBookTitle = null; // no book borrowed initially
    }

    // Getters
    public int getMemberId()             { return memberId; }
    public String getName()              { return name; }
    public String getBorrowedBookTitle() { return borrowedBookTitle; }

    // Setters
    public void setBorrowedBookTitle(String title) { this.borrowedBookTitle = title; }

    @Override
    public String toString() {
        String borrowed = (borrowedBookTitle != null) ? borrowedBookTitle : "None";
        return String.format("Member ID: %d | Name: %-20s | Borrowed: %s", memberId, name, borrowed);
    }
}
