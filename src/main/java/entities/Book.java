package entities;

public class Book {
    private static Long counter = 1L;

    private Long id;
    private String title;
    private String ISBN;
    private Writer author;
    private Topic category;
    private int releaseYear;
    private int awardsReceived;
    private Long stock;

    public Book(String title, String ISBN, Writer author, Topic category, int releaseYear, int awardsReceived) {
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.category = category;
        this.releaseYear = releaseYear;
        this.awardsReceived = awardsReceived;
        this.id=counter;
        counter++;
        this.stock=1L;
    }

    public Long getId() {
        return id;
    }

    public void addCopies(Long copies) {
        stock+=copies;
    }

    public Long getStock() {
        return stock;
    }

    public void allocate() {
        this.stock-=1;
    }

    public void returnBook() {
        this.stock+=1;
    }
}
