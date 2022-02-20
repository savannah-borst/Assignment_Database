package Assignment.Database.DataAccess;

import Assignment.Database.ConnectionHelper;
import Assignment.Database.Models.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerRepository {
    private String URL = ConnectionHelper.ConnectionURL;
    private Connection conn = null;

    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            //Connect to database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook has been established.");

            //Make Query display: Id, first name, last name, country, postal code, phone number and email.
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer");

            //Execute statement
            ResultSet resultSet = preparedStatement.executeQuery();

            //Process results
            while (resultSet.next()) {
                customers.add(
                        //int customerId, String firstName, String lastName, String company, String address, String city,
                        //                    String state, String country, String postalCode, String phone, String fax, String email, int supportRepId
                        new Customer(
                                resultSet.getInt("CustomerId"),
                                resultSet.getString("FirstName"),
                                resultSet.getString("LastName"),
                                resultSet.getString("Country"),
                                resultSet.getString("PostalCode"),
                                resultSet.getString("Phone"),
                                resultSet.getString("Email")
                        ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception ex) {
                System.out.println("something went wrong while closing connection");
                System.out.println(ex.toString());
            }
        }
        return customers;
    }

    public Customer getCustomerById(int customerId) {
        Customer customer = null;
        try {
            //Connect to database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook has been established.");

            //Make Query display: Id, first name, last name, country, postal code, phone number and email.
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer WHERE CustomerId = ?");
            preparedStatement.setInt(1, customerId);

            //Execute statement
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getInt("CustomerId"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Country"),
                        resultSet.getString("PostalCode"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email")
                );
            }
            System.out.println("Select specific customer succesful");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return customer;
        }
}
