package Assignment.Database.DataAccess;

import Assignment.Database.Models.Customer;
import Assignment.Database.Models.CustomerCountry;
import Assignment.Database.Models.CustomerSpender;

import java.util.ArrayList;

public interface ICustomerRepository {
    public ArrayList<Customer> getAllCustomers();
    public Customer getCustomerById(String customerId);
    public Customer getCustomerByName(String firstName);
    public ArrayList<Customer> getPageOfCustomers();
    public Boolean addCustomer(Customer customer);
    public Boolean updateCustomer(Customer customer);
    public ArrayList<CustomerCountry> getCustomersCountry();
    public ArrayList<CustomerSpender> getCustomerSpending();
    public Customer getCustomerGenre(int customerId);
}
