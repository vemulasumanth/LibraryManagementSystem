package librarymanagement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manages a collection of books in the library.
 */
public class Library {
    private List<Book> books;

    /**
     * Constructs a Library object with an empty list of books.
     */
    public Library() {
        this.books = new ArrayList<>();
    }

    /**
     * Adds a book to the library if it does not already exist (based on ISBN).
     */
    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getISBN().equals(book.getISBN())) {
                // Book with the same ISBN already exists; do not add it
                return;
            }
        }
        books.add(book);
    }

    /**
     * Removes a book from the library based on its ISBN.
     */
    public void removeBook(String ISBN) {
        books.removeIf(book -> book.getISBN().equals(ISBN));
    }

    /**
     * Finds books by their title, case-insensitive.
     */
    public List<Book> findBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    /**
     * Finds books by their author, case-insensitive.
     */
    public List<Book> findBookByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    /**
     * Lists all books in the library.
     */
    public List<Book> listAllBooks() {
        return new ArrayList<>(books);
    }

    /**
     * Lists all available books in the library.
     */
    public List<Book> listAvailableBooks() {
        return books.stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }
}

