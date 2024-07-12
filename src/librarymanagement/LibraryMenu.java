package librarymanagement;
import java.util.List;
import java.util.Scanner;

/**
 * Provides a text-based menu for interacting with the library system.
 */
public class LibraryMenu {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Library Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Find Book by Title");
            System.out.println("4. Find Book by Author");
            System.out.println("5. List All Books");
            System.out.println("6. List Available Books");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    findBookByTitle();
                    break;
                case 4:
                    findBookByAuthor();
                    break;
                case 5:
                    listAllBooks();
                    break;
                case 6:
                    listAvailableBooks();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    /**
     * Adds a book to the library based on user input.
     */
    private static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int publicationYear = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        System.out.print("Is the book available (true/false): ");
        boolean isAvailable = scanner.nextBoolean();
        scanner.nextLine();  // Consume the newline

        Book book = new Book(title, author, ISBN, genre, publicationYear, department, isAvailable);
        library.addBook(book);
        System.out.println("Book added successfully!");
    }

    /**
     * Removes a book from the library based on its ISBN.
     */
    private static void removeBook() {
        System.out.print("Enter ISBN of the book to remove: ");
        String ISBN = scanner.nextLine();
        library.removeBook(ISBN);
        System.out.println("Book removed successfully!");
    }

    /**
     * Finds and displays books by title.
     */
    private static void findBookByTitle() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        List<Book> books = library.findBookByTitle(title);
        books.forEach(System.out::println);
    }

    /**
     * Finds and displays books by author.
     */
    private static void findBookByAuthor() {
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        List<Book> books = library.findBookByAuthor(author);
        if(books.isEmpty())
        {
        	System.out.println("There are no books in the library by "+author);
        }
        books.forEach(System.out::println);
    }

    /**
     * Lists and displays all books in the library.
     */
    private static void listAllBooks() {
        List<Book> books = library.listAllBooks();
        if(books.isEmpty())
        {
        	System.out.println("Books are not available at this time");
        }
        else
        {
        books.forEach(System.out::println);
        }
    }

    /**
     * Lists and displays all available books in the library.
     */
    private static void listAvailableBooks() {
        List<Book> books = library.listAvailableBooks();
        if(books.isEmpty())
        {
        	System.out.println("Books are not available at this time");
        }
        else
        {
        books.forEach(System.out::println);
        }
    }
}

