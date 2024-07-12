package librarymanagement.tests;


import librarymanagement.Book;
import librarymanagement.Library;
import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

import java.util.List;

/**
 * Unit tests for the Library class.
 */
public class LibraryTest {
    @Test
    public void testAddBook() {
        // Create a new library and book
        Library library = new Library();
        Book book = new Book("Title1", "Author1", "123", "Genre1", 2021, "Department1", true);

        // Add the book to the library
        library.addBook(book);

        // Verify the book was added
        assertEquals(1, library.listAllBooks().size());
    }

    @Test
    public void testAddDuplicateBook() {
        // Create a new library and two books with the same ISBN
        Library library = new Library();
        Book book1 = new Book("Title1", "Author1", "123", "Genre1", 2021, "Department1", true);
        Book book2 = new Book("Title2", "Author2", "123", "Genre2", 2022, "Department2", false);

        // Add both books to the library
        library.addBook(book1);
        library.addBook(book2);

        // Verify only one book was added due to duplicate ISBN
        assertEquals(1, library.listAllBooks().size());
    }

    @Test
    public void testRemoveBook() {
        // Create a new library and book
        Library library = new Library();
        Book book = new Book("Title1", "Author1", "123", "Genre1", 2021, "Department1", true);

        // Add and then remove the book from the library
        library.addBook(book);
        library.removeBook("123");

        // Verify the book was removed
        assertEquals(0, library.listAllBooks().size());
    }

    @Test
    public void testFindBookByTitle() {
        // Create a new library and books
        Library library = new Library();
        Book book1 = new Book("Title1", "Author1", "123", "Genre1", 2021, "Department1", true);
        Book book2 = new Book("Title2", "Author2", "456", "Genre2", 2022, "Department2", true);

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);

        // Find books by title
        List<Book> books = library.findBookByTitle("Title1");

        // Verify the correct book was found
        assertEquals(1, books.size());
        assertEquals("123", books.get(0).getISBN());
    }

    @Test
    public void testFindBookByAuthor() {
        // Create a new library and books
        Library library = new Library();
        Book book1 = new Book("Title1", "Author1", "123", "Genre1", 2021, "Department1", true);
        Book book2 = new Book("Title2", "Author2", "456", "Genre2", 2022, "Department2", true);

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);

        // Find books by author
        List<Book> books = library.findBookByAuthor("Author1");

        // Verify the correct book was found
        assertEquals(1, books.size());
        assertEquals("123", books.get(0).getISBN());
    }

    @Test
    public void testListAllBooks() {
        // Create a new library and books
        Library library = new Library();
        Book book1 = new Book("Title1", "Author1", "123", "Genre1", 2021, "Department1", true);
        Book book2 = new Book("Title2", "Author2", "456", "Genre2", 2022, "Department2", true);

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);

        // List all books in the library
        List<Book> books = library.listAllBooks();

        // Verify all books are listed
        assertEquals(2, books.size());
    }

    @Test
    public void testListAvailableBooks() {
        // Create a new library and books
        Library library = new Library();
        Book book1 = new Book("Title1", "Author1", "123", "Genre1", 2021, "Department1", true);
        Book book2 = new Book("Title2", "Author2", "456", "Genre2", 2022, "Department2", false);

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);

        // List available books in the library
        List<Book> books = library.listAvailableBooks();

        // Verify only available books are listed
        assertEquals(1, books.size());
        assertEquals("123", books.get(0).getISBN());
    }

    @Test
    public void testLibraryIntegration() {
        // Create a new library and books
        Library library = new Library();
        Book book1 = new Book("Title1", "Author1", "123", "Genre1", 2021, "Department1", true);
        Book book2 = new Book("Title2", "Author2", "456", "Genre2", 2022, "Department2", false);

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);

        // Verify adding books
        assertEquals(2, library.listAllBooks().size());

        // Verify finding books by title
        List<Book> booksByTitle = library.findBookByTitle("Title1");
        assertEquals(1, booksByTitle.size());
        assertEquals("123", booksByTitle.get(0).getISBN());

        // Verify finding books by author
        List<Book> booksByAuthor = library.findBookByAuthor("Author2");
        assertEquals(1, booksByAuthor.size());
        assertEquals("456", booksByAuthor.get(0).getISBN());

        // Verify listing available books
        List<Book> availableBooks = library.listAvailableBooks();
        assertEquals(1, availableBooks.size());
        assertEquals("123", availableBooks.get(0).getISBN());

        // Verify removing books
        library.removeBook("123");
        assertEquals(1, library.listAllBooks().size());
    }
}

