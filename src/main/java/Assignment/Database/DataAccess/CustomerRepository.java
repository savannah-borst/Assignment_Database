package Assignment.Database.DataAccess;

import Assignment.Database.ConnectionHelper;
import Assignment.Database.Models.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerRepository {
    private String URL = ConnectionHelper.ConnectionURL;
    private Connection conn = null;

    //Read all the customers in the database
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

                        //Make Query display: Id, first name, last name, country, postal code, phone number and email.
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

        } catch (Exception exception) {
            System.out.println("Please check your query");
            System.out.println(exception.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception exception) {
                System.out.println("something went wrong while closing connection");
                System.out.println(exception.toString());
            }
        }
        return customers;
    }

    //Read a specific customer from the database (by Id)
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
            System.out.println("Select specific customer successful");

        } catch (Exception exception) {
            System.out.println("Please check your query");
            System.out.println(exception);
        } finally {
            try {
                conn.close();
                System.out.println("Closed connection with success");
            } catch (Exception exception) {
                System.out.println("something went wrong while closing connection");
                System.out.println(exception.toString());
            }
        }
        return customer;
        }

        //Read a specific customer by name
    public Customer getCustomerByName(String firstName) {
        Customer customer = null;

        try {
            //Connect to Database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook has been established.");

            //Make query
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer WHERE FirstName LIKE ?");
            preparedStatement.setString(1, firstName);

            //Execute Statement
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
            System.out.println("Select specific customer successful");

        } catch (Exception exception)  {
            System.out.println("Please check your query");
            System.out.println(exception);
        } finally {
            try {
                conn.close();
                System.out.println("Closed connection with success");
            } catch (Exception exception) {
                System.out.println("something went wrong while closing connection");
                System.out.println(exception.toString());
            }
        }
        return customer;
    }

    //Return a page of customers from the database.
    public ArrayList<Customer> getPageOfCustomers(int from, int to) {
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            //Connect to database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook has been established.");

            //Make query
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer WHERE CustomerId BETWEEN ? AND ?");
            preparedStatement.setInt(1, from);
            preparedStatement.setInt(2, to);

            //Execute statement
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customers.add(
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

        } catch (Exception exception)  {
            System.out.println("Please check your query");
            System.out.println(exception);
        } finally {
            try {
                conn.close();
                System.out.println("Closed connection with success");
            } catch (Exception exception) {
                System.out.println("something went wrong while closing connection");
                System.out.println(exception.toString());
            }
        }

        return customers;
    }
}
