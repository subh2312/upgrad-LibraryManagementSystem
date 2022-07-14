package service;

import dao.LibraryDatabase;
import entities.*;

import java.util.List;

public class LibraryServiceImpl implements LibraryService{
    private LibraryDatabase database;

    public LibraryServiceImpl(){
        database = new LibraryDatabase();
    }
    @Override
    public void getAllTopics() {
        List<Topic> topicList = database.getAllTopics();
        for(int i=0;i< topicList.size();i++){
            System.out.println((i+1)+". "+topicList.get(i).getName());
        }
    }

    @Override
    public void getBooksByTopic(Long id) {
        List<Book> bookList = database.getBookByTopicId(id);
    }

    @Override
    public void getAllAuthors() {
        List<Writer> writerList = database.getAllAuthors();
    }

    @Override
    public void getBooksByAuthor(Long id) {
        List<Book> bookList = database.getBookByAuthor(id);
    }

    @Override
    public void returnBook(Long id, Long bookId) {
        database.returnBook(id,bookId);
        Book book = database.getBookById(bookId);
        book.returnBook();


    }

    @Override
    public void allocateBook(Long id, Long bookId) {
        List<Long> bookIds = database.getAllBookIds(id);
        List<Book> books = database.getAllBooks();
        boolean flag=true;
        for (Book b:books){
            if(b.getId()!=bookId){
                flag=false;
            }
        }
        Book book = database.getBookById(id);
        if(bookIds.size()>=3){
            System.out.println("User Already has 3 books can not assign more. Please return a book first");
        }else{
            if(bookIds.contains(bookId)){
                System.out.println("User already has one copy of the book. Can not assign again");
            }else{
                if(book.getStock()==0 || flag==false){
                    System.out.println("Sorry!! Book Not Available in Library");
                }else{
                    database.allocateBookToUser(id,bookId);
                    book.allocate();
                }
            }
        }
    }

    @Override
    public void addCopyOfExistingBook(Long id, Long copies) {
        Book book = database.getBookById(id);
        book.addCopies(copies);

    }

    @Override
    public void addBook(String title, String isbn, Long authorId, Long topicId, int year, int awards) {
        Topic topic=database.geTopicById(topicId);
        Writer author = database.getAuthorById(authorId);

        Book book = new Book(title,isbn,author,topic,year,awards);
        database.addBook(book);
    }

    @Override
    public void registerWriter(String firstName, String lastName, int awards, int activeSince) {
        Writer writer = new Writer(firstName,lastName,awards,activeSince);
        database.addWriter(writer);
    }

    @Override
    public void registerUser(String firstName, String lastName, Long phoneNumber, String emailId, String city, String locality, String state, Long pinCode) {
        Contact contact=new Contact(emailId,phoneNumber);
        Address address = new Address(city, locality, state, pinCode);
        User user = new User(firstName,lastName,contact,address);
        database.addUser(user);
    }

    @Override
    public List<Book> getBooksByUser(Long id) {
        List<Book> bookList=database.getBooksByUserId(id);
        return (bookList);
    }

    @Override
    public List<Book> getAllBooks() {
       List<Book> bookList= database.getAllBooks();
       return bookList;
    }
}
