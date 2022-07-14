package entities;

public class Writer {
    private static Long counter = 1L;
    private Long id;
    private String firstName;
    private String lastName;
    private int awardsReceived;
    private int activeSince;

    public Writer(String firstName, String lastName, int awardsReceived, int activeSince) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.awardsReceived = awardsReceived;
        this.activeSince = activeSince;
        this.id=counter;
        counter++;
    }

    public Long getId() {
        return id;
    }
}
