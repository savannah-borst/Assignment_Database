package Assignment.Database.DataAccess;

import Assignment.Database.ConnectionHelper;
import Assignment.Database.Models.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerGenre {
    private final String URL = ConnectionHelper.ConnectionURL;
    private Connection conn = null;

    // For a given customer give their most popular genre
    public Customer getCustomerGenre(int customerId) {
        Customer customer = null;

        try {
            //Connect to Database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook has been established.");

            //Make query
            // For a given customer, their most popular genre (in the case of a tie, display both).
            // Most popular in this context means the genre that corresponds to the most tracks from invoices associated with that customer.
            PreparedStatement preparedStatement = conn.prepareStatement("WITH GenrePopularity AS\n" +
                    "         (Select Count(G.GenreId) as Popularity, C.FirstName, C.LastName, C.CustomerId, G.Name\n" +
                    "          FROM Customer C\n" +
                    "                   JOIN Invoice I on C.CustomerId = I.CustomerId\n" +
                    "                   JOIN InvoiceLine IL on I.InvoiceId = IL.InvoiceId\n" +
                    "                   JOIN Track T on IL.TrackId = T.TrackId\n" +
                    "                   JOIN Genre G on T.GenreId = G.GenreId\n" +
                    "          WHERE C.CustomerId = ?\n" +
                    "          GROUP BY G.Name)\n" +
                    "\n" +
                    "\n" +
                    "SELECT gp.CustomerId, gp.FirstName, gp.LastName, gp.Name, gp.Popularity\n" +
                    "FROM GenrePopularity gp\n" +
                    "WHERE gp.Popularity = (SELECT max(Popularity) FROM GenrePopularity)");
            preparedStatement.setInt(1, customerId);

            //Execute Statement
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
        return customer;
    }
}
