package Assignment.Database.DataAccess;

import Assignment.Database.Models.Customer;
import Assignment.Database.Models.CustomerCountry;
import Assignment.Database.Models.CustomerGenre;
import Assignment.Database.Models.CustomerSpender;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private final String URL = ConnectionHelper.ConnectionURL;
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
    public Customer getCustomerById(String customerId) {
        Customer customer = null;

        try {
            //Connect to database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook has been established.");

            //Make Query display: Id, first name, last name, country, postal code, phone number and email.
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer WHERE CustomerId = ?");
            preparedStatement.setString(1, customerId);

            //Execute statement
            ResultSet resultSet = preparedStatement.executeQuery();

            //Process Results
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
    public Customer getCustomerByName(String firstName, String lastName) {
        Customer customer = null;

        try {
            //Connect to Database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook has been established.");

            //Make query
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer WHERE FirstName LIKE ? AND LastName LIKE ?");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);

            //Execute Statement
            ResultSet resultSet = preparedStatement.executeQuery();

            //Process results
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
    public ArrayList<Customer> getPageOfCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            //Connect to database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook has been established.");

            //Make query
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer WHERE CustomerId LIMIT 10 OFFSET 49");

            //Execute statement
            ResultSet resultSet = preparedStatement.executeQuery();

            //Process results
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

    //Add a new customer
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
            preparedStatement.executeUpdate();
            success = true;
            System.out.println("You successfully added a customer");

        } catch (Exception exception) {
            System.out.println("Please check your query");
            System.out.println(exception.toString());
        }
        finally {
            try {
                conn.close();
                System.out.println("Closed connection with success");
            } catch (Exception exception) {
                System.out.println("something went wrong while closing connection");
                System.out.println(exception.toString());
            }
        }
        return success;
    }

    //Update a certain customer
    public Boolean updateCustomer(String customerId, Customer customer) {
        Boolean success = false;

        try {
            //Connect to Database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook has been established.");

            //Make SQL UPDATE query
            PreparedStatement preparedStatement =
                    conn.prepareStatement("UPDATE customer SET FirstName = ?, LastName = ?, Country = ?,PostalCode = ?,Phone = ?,Email = ? WHERE CustomerId = ?");
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getCountry());
            preparedStatement.setString(4, customer.getPostalCode());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customerId);

            //Execute SQL UPDATE query
            preparedStatement.executeUpdate();
            success = true;
            System.out.println("You successfully updated a customer");

        } catch (Exception exception) {
            System.out.println("Please check your query");
            System.out.println(exception.toString());
        }
        finally {
            try {
                conn.close();
                System.out.println("Closed connection with success");
            } catch (Exception exception) {
                System.out.println("something went wrong while closing connection");
                System.out.println(exception.toString());
            }
        }
        return success;
    }

    //Read customers from each country
    public ArrayList<CustomerCountry> getCustomersCountry() {
        ArrayList<CustomerCountry> customersInCountry = new ArrayList<>();

        try {
            //Connect to database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook has been established");

            //Make SQL COUNT query
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT COUNT(CustomerId), Country " +
                            "FROM Customer " +
                            "GROUP BY " +
                            "Country ORDER BY COUNT(*) DESC");

            //Execute COUNT Query
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customersInCountry.add(
                        new CustomerCountry(
                                resultSet.getString(2),
                                resultSet.getInt(1)
                        )
                );
                System.out.println("Select specific country successfully");
            }

        } catch (Exception exception) {
            System.out.println("Please check your query");
            System.out.println(exception.toString());
        }
        finally {
            try {
                conn.close();
                System.out.println("Closed connection with success");
            } catch (Exception exception) {
                System.out.println("something went wrong while closing connection");
                System.out.println(exception.toString());
            }
        }
        return customersInCountry;
    }

    public ArrayList<CustomerSpender> getCustomerSpending() {
        ArrayList<CustomerSpender> customerSpender = new ArrayList<>();

        try {
            //Connect to database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection established");

            //Make SQL COUNT query
            PreparedStatement statement = conn.prepareStatement("SELECT  C.CustomerId, C.FirstName, C.LastName, SUM(I.Total) AS Total " +
                    "FROM Customer C " +
                    "JOIN Invoice I on C.CustomerId = I.CustomerId " +
                    "GROUP BY C.CustomerId " +
                    "ORDER BY Total DESC");

            //Execute query
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                customerSpender.add(
                        new CustomerSpender(
                                resultSet.getInt("CustomerId"),
                                resultSet.getString("FirstName"),
                                resultSet.getString("LastName"),
                                resultSet.getDouble("Total")
                        )
                );
            }
            System.out.println("Select specific total spend by customer successfully");

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
        return customerSpender;
    }

    // For a given customer give their most popular genre
    public ArrayList<CustomerGenre> getCustomerGenre(String customerId) {
        ArrayList<CustomerGenre> customerGenre = new ArrayList<>();

        try {
            //Connect to Database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook has been established.");

            //Make query
            // For a given customer, their most popular genre (in the case of a tie, display both).
            PreparedStatement preparedStatement = conn.prepareStatement("WITH GenrePopularity AS\n" +
                    "         (Select Count(G.GenreId) as Popularity, C.FirstName, C.LastName, C.CustomerId, G.Name\n" +
                    "          FROM Customer C\n" +
                    "                   JOIN Invoice I on C.CustomerId = I.CustomerId\n" +
                    "                   JOIN InvoiceLine IL on I.InvoiceId = IL.InvoiceId\n" +
                    "                   JOIN Track T on IL.TrackId = T.TrackId\n" +
                    "                   JOIN Genre G on T.GenreId = G.GenreId\n" +
                    "          WHERE C.CustomerId = ?\n" +
                    "          GROUP BY G.Name)\n" +
                    "SELECT gp.CustomerId, gp.FirstName, gp.LastName, gp.Name, gp.Popularity\n" +
                    "FROM GenrePopularity gp\n" +
                    "WHERE gp.Popularity = (SELECT max(Popularity) FROM GenrePopularity)");
            preparedStatement.setString(1, customerId);

            //Execute Statement
            ResultSet resultSet = preparedStatement.executeQuery();

            //Process Results
            while (resultSet.next()) {
                customerGenre.add(
                        new CustomerGenre(
                        resultSet.getInt("CustomerId"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Name")
                        )
                );
            }
            System.out.println("Select specific customer plus genre successful");

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
        return customerGenre;
    }
}
