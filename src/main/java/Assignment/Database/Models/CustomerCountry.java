package Assignment.Database.Models;

public class CustomerCountry {

    //Fields
    private String countryName;
    private int totalCustomers;

    //Constructor
    public CustomerCountry(String countryName, int totalCustomers) {
        this.countryName = countryName;
        this.totalCustomers = totalCustomers;
    }

    //Getters and Setters
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(int totalCustomers) {
        this.totalCustomers = totalCustomers;
    }
}
