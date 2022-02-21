package Assignment.Database;

import Assignment.Database.DataAccess.CustomerAddAndUpdate;
import Assignment.Database.Models.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class DatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
		CustomerAddAndUpdate customerAddAndUpdate = new CustomerAddAndUpdate();

		Customer richie = new Customer(80, "Richie", "Schuurman", "Nederland",
				"1161XC", "0612345678", "richie@hotmail.com");

		//customerAddAndUpdate.addCustomer(richie);

		Customer updateRichie = new Customer(80, "Richie", "Schuurman", "Netherlands",
				"1024NS", "0698765432", "schuurman@hotmail.com");

		customerAddAndUpdate.updateCustomer(updateRichie);
	}
}
