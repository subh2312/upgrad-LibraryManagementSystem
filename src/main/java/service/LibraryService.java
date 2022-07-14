package service;

import entities.Book;

import java.util.List;

public interface LibraryService {
    void getAllTopics();

    void getBooksByTopic(Long id);

    void getAllAuthors();

    void getBooksByAuthor(Long id);

    void returnBook(Long id, Long bookId);

    void allocateBook(Long id, Long bookId);

    void addCopyOfExistingBook(Long id, Long copies);

    void addBook(String title, String isbn, Long authorId, Long topicId, int year, int awards);

    void registerWriter(String firstName, String lastName, int awards, int activeSince);

    void registerUser(String firstName, String lastName, Long phoneNumber, String emailId, String city, String locality, String state, Long pinCode);

    List<Book> getBooksByUser(Long id);

    List<Book> getAllBooks();
}
