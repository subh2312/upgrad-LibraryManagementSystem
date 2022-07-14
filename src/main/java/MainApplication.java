import service.LibraryService;
import service.LibraryServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        int choice=0;
        Scanner sc = new Scanner(System.in);
        LibraryService service = new LibraryServiceImpl();

        while(choice != -1) {
            printCommandTemplate();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    registerUser(service, sc);
                    break;
                case 2:
                    registerWriter(service, sc);
                    break;
                case 3:
                    addNewBook(service, sc);
                    break;
                case 4:
                    addCopiesofExistingBook(service, sc);
                    break;
                case 5:
                    allocateBookToUser(service, sc);
                    break;
                case 6:
                    returnBook(service, sc);
                    break;
                case 7:
                    getBookByAuthor(service, sc);
                    break;
                case 8:
                    getBookByTopic(service, sc);
                    break;
                case -1:
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    break;
            }
        }
    }

    private static void getBookByTopic(LibraryService service, Scanner sc) {
        service.getAllTopics();
        System.out.println("Please Enter Topic or Category Number : ");
        Long id = sc.nextLong();
        service.getBooksByTopic(id);
    }

    private static void getBookByAuthor(LibraryService service, Scanner sc) {
        service.getAllAuthors();
        System.out.println("Please Enter Author Id : ");
        Long id = sc.nextLong();
        service.getBooksByAuthor(id);
    }

    private static void returnBook(LibraryService service, Scanner sc) {
        System.out.println("Please enter user id :");
        Long userId = sc.nextLong();
        service.getBooksByUser(userId);
        System.out.println("Please select book id to return:");
        Long bookId = sc.nextLong();
        service.returnBook(userId,bookId);
    }

    private static void allocateBookToUser(LibraryService service, Scanner sc) {
        System.out.println("Please enter user id :");
        Long id = sc.nextLong();
        service.getAllBooks();
        System.out.println("Enter book id to borrow :");
        Long bookId = sc.nextLong();
        service.allocateBook(id,bookId);
    }

    private static void addCopiesofExistingBook(LibraryService service, Scanner sc) {
        System.out.println("Please enter book id to add a copy : ");
        Long id = sc.nextLong();
        System.out.println("Enter number of copies you want to add:");
        Long copies = sc.nextLong();
        service.addCopyOfExistingBook(id,copies);
    }

    private static void addNewBook(LibraryService service, Scanner sc) {
        System.out.println("Please enter Title : ");
        String title = sc.next();
        System.out.println("Please enter ISBN : ");
        String isbn = sc.next();
        service.getAllAuthors();
        System.out.println("Please select author id(Select 0 if author not registered) : ");
        Long authorId = sc.nextLong();
        service.getAllTopics();
        System.out.println("Please Enter Topic or Category Number(Select 0 if author not registered) : ");
        Long topicId = sc.nextLong();
        System.out.println("Please enter release year :");
        int year = sc.nextInt();
        System.out.println("Please enter awards received : ");
        int awards = sc.nextInt();
        service.addBook(title,isbn,authorId,topicId,year,awards);
    }

    private static void registerWriter(LibraryService service, Scanner sc) {
        System.out.println("Enter the first Name : ");
        String firstName = sc.next();
        System.out.println("Enter the last Name : ");
        String lastName = sc.next();
        System.out.println("Enter awards received : ");
        int awards = sc.nextInt();
        System.out.println("Enter the year since author is active :");
        int activeSince = sc.nextInt();

        service.registerWriter(firstName, lastName,awards,activeSince);
    }

    private static void registerUser(LibraryService service, Scanner sc) {
        System.out.println("Enter the first Name : ");
        String firstName = sc.next();
        System.out.println("Enter the last Name : ");
        String lastName = sc.next();
        System.out.println("Enter the Email Id : ");
        String emailId = sc.next();
        System.out.println("Enter the Phone Number : ");
        Long phoneNumber = sc.nextLong();
        System.out.println("Enter the city : ");
        String city = sc.next();
        System.out.println("Enter the locality : ");
        String locality = sc.next();
        System.out.println("Enter the state : ");
        String state = sc.next();
        System.out.println("Enter the Pin Code : ");
        Long pinCode = sc.nextLong();

        service.registerUser(firstName, lastName, phoneNumber,emailId,
                city, locality, state, pinCode);
    }

    private static void printCommandTemplate() {
        System.out.println("Enter the choice");
        System.out.println("1. To register a User");
        System.out.println("2. Add a writer");
        System.out.println("3. Add a new book");
        System.out.println("4. Add copies of an existing book");
        System.out.println("5. Allocate a copy of a book to an user");
        System.out.println("6. Return a copy of the book");
        System.out.println("7. Get books of an author");
        System.out.println("8. Get books of a specific category.");
        System.out.println("-1. To quit");
    }
}
