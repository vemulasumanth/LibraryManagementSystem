package librarymanagement.tests;


import librarymanagement.Book;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Book class.
 */
public class BookTest {
    @Test
    public void testGettersAndSetters() {
        // Create a new book
        Book book = new Book("Title1", "Author1", "123", "Genre1", 2021, "Department1", true);

        // Test getters
        assertEquals("Title1", book.getTitle());
        assertEquals("Author1", book.getAuthor());
        assertEquals("123", book.getISBN());
        assertEquals("Genre1", book.getGenre());
        assertEquals(2021, book.getPublicationYear());
        assertEquals("Department1", book.getDepartment());
        assertTrue(book.isAvailable());

        // Test setters
        book.setTitle("NewTitle");
        book.setAuthor("NewAuthor");
        book.setISBN("456");
        book.setGenre("NewGenre");
        book.setPublicationYear(2022);
        book.setDepartment("NewDepartment");
        book.setAvailable(false);

        // Verify setters
        assertEquals("NewTitle", book.getTitle());
        assertEquals("NewAuthor", book.getAuthor());
        assertEquals("456", book.getISBN());
        assertEquals("NewGenre", book.getGenre());
        assertEquals(2022, book.getPublicationYear());
        assertEquals("NewDepartment", book.getDepartment());
        assertFalse(book.isAvailable());
    }

    @Test
    public void testToString() {
        // Create a new book
        Book book = new Book("Title1", "Author1", "123", "Genre1", 2021, "Department1", true);
        String expectedString = "Book{title='Title1', author='Author1', ISBN='123', genre='Genre1', publicationYear=2021, department='Department1', isAvailable=true}";
        assertEquals(expectedString, book.toString());
    }

    @Test
    public void testBookEquality() {
        // Create two books with the same attributes
        Book book1 = new Book("Title1", "Author1", "123", "Genre1", 2021, "Department1", true);
        Book book2 = new Book("Title1", "Author1", "123", "Genre1", 2021, "Department1", true);

        // Ensure the books are equal based on attributes
        assertEquals(book1.getTitle(), book2.getTitle());
        assertEquals(book1.getAuthor(), book2.getAuthor());
        assertEquals(book1.getISBN(), book2.getISBN());
        assertEquals(book1.getGenre(), book2.getGenre());
        assertEquals(book1.getPublicationYear(), book2.getPublicationYear());
        assertEquals(book1.getDepartment(), book2.getDepartment());
        assertEquals(book1.isAvailable(), book2.isAvailable());
    }
}
