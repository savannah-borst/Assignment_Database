package Assignment.Database.Models;

public class CustomerGenre {
    //Fields
    private int customerId;
    private String firstName;
    private String lastName;
    private String genreName;

    //Constructor
    public CustomerGenre(int customerId, String firstName, String lastName, String genreName) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.genreName = genreName;
    }

    //Getters and Setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
