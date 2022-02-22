package Assignment.Database.Controllers;

import Assignment.Database.Models.Customer;
import Assignment.Database.Models.CustomerCountry;
import Assignment.Database.Models.CustomerSpender;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api")
public class CustomerAPIController {

    @GetMapping("customers")
    public ArrayList<Customer> getAllCustomers() {
        return null;
    }

    @GetMapping("customer/{customerId}")
    public Customer getCustomerById(int customerId) {
        return null;
    }

    @GetMapping("customer/{firstName}")
    public Customer getCustomerByName(String firstName) {
        return null;
    }

    @GetMapping("customer/page")
    public ArrayList<Customer> getPageOfCustomers() {
        return null;
    }

    @PostMapping("customer/add/{customer}")
    public Boolean addCustomer(Customer customer) {
        return null;
    }

    @PutMapping("customer/update/{customer}")
    public Boolean updateCustomer(Customer customer) {
        return null;
    }

    @GetMapping("customer/country")
    public ArrayList<CustomerCountry> getCustomersCountry(){
        return null;
    }

    @GetMapping("customer/spending")
    public ArrayList<CustomerSpender> getCustomerSpending(){
        return null;
    }

    @GetMapping("customer/{customerId}/most/popular/genre")
    public Customer getCustomerGenre(int customerId) {
        return null;
    }
}
