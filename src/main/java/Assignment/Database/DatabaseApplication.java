package Assignment.Database;

import Assignment.Database.DataAccess.CustomerRepository;
import Assignment.Database.Models.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class DatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
		CustomerRepository customerRepository = new CustomerRepository();
		ArrayList<Customer> customers = customerRepository.getAllCustomers();
		Customer customer = customerRepository.getCustomerById(5);

		//printCustomers(customers);
		printCustomer(customer);

	}

	public static void printCustomers(ArrayList<Customer> customers) {
		if (customers.size() != 0) {
			for (Customer c : customers) {
				System.out.println("-------------------------------");
				System.out.println(c.getCustomerId());
				System.out.println(c.getFirstName());
				System.out.println(c.getLastName());
				System.out.println(c.getCountry());
				System.out.println(c.getPostalCode());
				System.out.println(c.getPhone());
				System.out.println(c.getEmail());
			}
		} else {
			System.out.println("No customers returned");
		}
	}

	public static void printCustomer(Customer customer) {
		if(customer != null){
			System.out.println("-------------------------------");
			System.out.println(customer.getCustomerId());
			System.out.println(customer.getFirstName());
			System.out.println(customer.getLastName());
			System.out.println(customer.getCountry());
			System.out.println(customer.getPostalCode());
			System.out.println(customer.getPhone());
			System.out.println(customer.getEmail());
		} else {
			System.out.println("No customer with that ID exists");
		}

	}
}
