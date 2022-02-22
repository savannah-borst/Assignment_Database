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

    }

    @GetMapping("customer/{customerId}")
    public Customer getCustomerById(int customerId) {

    }

    @GetMapping("customer/{firstName}")
    public Customer getCustomerByName(String firstName) {

    }

    @GetMapping("customer/page")
    public ArrayList<Customer> getPageOfCustomers() {

    }

    @PostMapping("customer/add/{customer}")
    public Boolean addCustomer(Customer customer) {

    }

    @PutMapping("customer/update/{customer}")
    public Boolean updateCustomer(Customer customer) {

    }

    @GetMapping("customer/country")
    public ArrayList<CustomerCountry> getCustomersCountry(){

    }

    @GetMapping("customer/spending")
    public ArrayList<CustomerSpender> getCustomerSpending(){

    }

    @GetMapping("customer/{customerId}/most/popular/genre")
    public Customer getCustomerGenre(int customerId) {

    }
}
