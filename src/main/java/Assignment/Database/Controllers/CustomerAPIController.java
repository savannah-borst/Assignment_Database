package Assignment.Database.Controllers;

import Assignment.Database.DataAccess.ICustomerRepository;
import Assignment.Database.Models.Customer;
import Assignment.Database.Models.CustomerCountry;
import Assignment.Database.Models.CustomerSpender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class CustomerAPIController {
    private final ICustomerRepository customerRepository;

    public CustomerAPIController (
            @Autowired ICustomerRepository customerRepository
    ) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public ArrayList<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        return customerRepository.getCustomerById(id);
    }

    @GetMapping("/customers/")
    @ResponseBody
    public Customer getCustomerByName(@RequestParam String firstName) {
        return customerRepository.getCustomerByName(firstName);
    }

    @GetMapping("/customers/page")
    public ArrayList<Customer> getPageOfCustomers() {
        return customerRepository.getPageOfCustomers();
    }

    @PostMapping("/customers/add")
    public Boolean addCustomer(Customer customer) {
        return null;
    }

    @PutMapping("/customers/update/{customer}")
    public Boolean updateCustomer(Customer customer) {
        return null;
    }

    @GetMapping("/customers/country")
    public ArrayList<CustomerCountry> getCustomersCountry(){
        return customerRepository.getCustomersCountry();
    }

    @GetMapping("/customers/spending")
    public ArrayList<CustomerSpender> getCustomerSpending(){
        return customerRepository.getCustomerSpending();
    }

    @GetMapping("/customers/{id}/most/popular/genre")
    public Customer getCustomerGenre(String id) {
        return null;
    }
}
