// Main.java - Entry point with interactive menu
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("==========================================");
        System.out.println("   WELCOME TO LIBRARY MANAGEMENT SYSTEM  ");
        System.out.println("==========================================");

        do {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: // View all books
                    library.viewAllBooks();
                    break;

                case 2: // Add a book
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();
                    library.addBook(title, author);
                    break;

                case 3: // Search book
                    System.out.print("Enter title or author to search: ");
                    String keyword = sc.nextLine();
                    library.searchBook(keyword);
                    break;

                case 4: // Delete a book
                    library.viewAllBooks();
                    System.out.print("Enter Book ID to delete: ");
                    int delId = sc.nextInt();
                    library.deleteBook(delId);
                    break;

                case 5: // Register member
                    System.out.print("Enter member name: ");
                    String memberName = sc.nextLine();
                    library.addMember(memberName);
                    break;

                case 6: // View all members
                    library.viewAllMembers();
                    break;

                case 7: // Borrow book
                    library.viewAllMembers();
                    System.out.print("Enter Member ID: ");
                    int mId = sc.nextInt();
                    library.viewAllBooks();
                    System.out.print("Enter Book ID to borrow: ");
                    int bId = sc.nextInt();
                    library.borrowBook(mId, bId);
                    break;

                case 8: // Return book
                    library.viewAllMembers();
                    System.out.print("Enter Member ID: ");
                    int rMId = sc.nextInt();
                    library.viewAllBooks();
                    System.out.print("Enter Book ID to return: ");
                    int rBId = sc.nextInt();
                    library.returnBook(rMId, rBId);
                    break;

                case 9:
                    System.out.println("Thank you! Exiting Library System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 9);

        sc.close();
    }

    static void printMenu() {
        System.out.println("\n---------- MENU ----------");
        System.out.println("1. View All Books");
        System.out.println("2. Add a Book");
        System.out.println("3. Search Book");
        System.out.println("4. Delete a Book");
        System.out.println("5. Register Member");
        System.out.println("6. View All Members");
        System.out.println("7. Borrow Book");
        System.out.println("8. Return Book");
        System.out.println("9. Exit");
        System.out.println("--------------------------");
    }
}
