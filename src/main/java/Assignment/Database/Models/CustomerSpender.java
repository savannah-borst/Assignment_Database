package Assignment.Database.Models;

public class CustomerSpender {
    //Fields
    private int customerId;
    private String firstName;
    private String lastName;
    private double totalSpend;

    //Constructor
    public CustomerSpender(int customerId, String firstName, String lastName, double totalSpend) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalSpend = totalSpend;
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

    public double getTotalSpend() {
        return totalSpend;
    }

    public void setTotalSpend(double totalSpend) {
        this.totalSpend = totalSpend;
    }
}
