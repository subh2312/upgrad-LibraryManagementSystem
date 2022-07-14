package dao;

import entities.Book;
import entities.Topic;
import entities.User;
import entities.Writer;

import java.util.*;

public class LibraryDatabase {
    private Map<Long, Topic> topics;
    private Map<Long, Writer> writers;
    private Map<Long, User> users;

    private Map<Long,Book> books;
    private Map<Long, List<Long>> authorIdToBookId;
    private Map<Long, List<Long>> userIdToBookId;
    private Map<Long, List<Long>> topicIdToBookId;

    public LibraryDatabase(){
        this.topics=new HashMap<>();
        this.writers=new HashMap<>();
        this.users = new HashMap<>();
        this.authorIdToBookId = new HashMap<>();
        this.userIdToBookId = new HashMap<>();
        this.topicIdToBookId = new HashMap<>();
        this.books=new HashMap<>();
    }
    public List<Topic> getAllTopics() {
        List<Topic> topicList = new ArrayList<>();
        for(Topic t:topics.values()){
            topicList.add(t);
        }
        return topicList;
    }

    public List<Book> getBookByTopicId(Long id) {
        List<Long> bookIds = new ArrayList<>();
        List<Book> bookList = new ArrayList<>();
        for(List<Long> idList:topicIdToBookId.values()){
            bookIds = idList;
        }
        for(Long ids:bookIds){
            bookList.add(getBookById(id));
        }
        return bookList;
    }

    public Book getBookById(Long id) {
        return books.get(id);
    }

    public List<Writer> getAllAuthors() {
        List<Writer> writerList = new ArrayList<>();
        for (Writer w:writers.values()){
            writerList.add(w);
        }
        return writerList;
    }

    public List<Book> getBookByAuthor(Long id) {
        List<Long> bookIds = new ArrayList<>();
        List<Book> bookList = new ArrayList<>();
        for(List<Long> idList:authorIdToBookId.values()){
            bookIds = idList;
        }
        for(Long ids:bookIds){
            bookList.add(getBookById(id));
        }
        return bookList;
    }


    public User getUserByID(Long id) {
        return users.get(id);
    }

    public void addUser(User user) {
        users.put(user.getId(),user);
    }

    public void addWriter(Writer writer) {
        writers.put(writer.getId(),writer);
    }

    public Topic geTopicById(Long topicId) {
        return topics.get(topicId);
    }

    public Writer getAuthorById(Long authorId) {
        return writers.get(authorId);
    }

    public void addBook(Book book) {
        books.put(book.getId(),book);
    }

    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        for (Book b:books.values()){
            bookList.add(b);
        }
        return bookList;
    }

    public List<Long> getAllBookIds(Long id) {
        List<Long> idList = userIdToBookId.get(id);

        return idList;
    }

    public void allocateBookToUser(Long id, Long bookId) {
        List<Long> idList = userIdToBookId.get(id);
        idList.add(bookId);
        userIdToBookId.put(id,idList);
    }

    public List<Book> getBooksByUserId(Long id) {
        List<Long> idList = userIdToBookId.get(id);
        List<Book> bookList = new ArrayList<>();
        for (Long ids:idList){
            bookList.add(getBookById(ids));
        }
        return bookList;
    }

    public void returnBook(Long id, Long bookId) {
        List<Long> idList =userIdToBookId.get(id);
        idList.remove(bookId);
        userIdToBookId.put(id,idList);
    }
}
