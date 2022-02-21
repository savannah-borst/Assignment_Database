package Assignment.Database.DataAccess;

import Assignment.Database.ConnectionHelper;
import Assignment.Database.Models.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerAddAndUpdate {
    private String URL = ConnectionHelper.ConnectionURL;
    private Connection conn = null;

    public Boolean addCustomer(Customer customer) {
        Boolean success = false;

        try {
            //Connect to Database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook has been established.");

            //Make SQL INSERT query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO customer(CustomerId,FirstName,LastName,Country,PostalCode,Phone,Email) VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,customer.getCustomerId());
            preparedStatement.setString(2,customer.getFirstName());
            preparedStatement.setString(3,customer.getLastName());
            preparedStatement.setString(4,customer.getCountry());
            preparedStatement.setString(5,customer.getPostalCode());
            preparedStatement.setString(6,customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());

            //Execute SQL INSERT query
            int result = preparedStatement.executeUpdate();
            success = (result != 0);
            System.out.println("You successfully added a customer");

        } catch (Exception exception) {
            System.out.println("Please check your query");
            System.out.println(exception.toString());
        }
        finally {
            try {
                conn.close();
            } catch (Exception exception) {
                System.out.println("something went wrong while closing connection");
                System.out.println(exception.toString());
            }
        }
        return success;
    }

    public Boolean updateCustomer(Customer customer) {
        Boolean success = false;

        try {
            //Connect to Database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook has been established.");

            //Make SQL UPDATE query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("UPDATE customer SET Country = ?,PostalCode = ?,Phone = ?,Email = ? WHERE CustomerId = ?");
            preparedStatement.setString(1, customer.getCountry());
            preparedStatement.setString(2, customer.getPostalCode());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setInt(5, customer.getCustomerId());

            //Execute SQL UPDATE query
            int result = preparedStatement.executeUpdate();
            success = (result != 0);
            System.out.println("You successfully updated a customer");

        } catch (Exception exception) {
            System.out.println("Please check your query");
            System.out.println(exception.toString());
        }
        finally {
            try {
                conn.close();
            } catch (Exception exception) {
                System.out.println("something went wrong while closing connection");
                System.out.println(exception.toString());
            }
        }
        return success;
    }
}
