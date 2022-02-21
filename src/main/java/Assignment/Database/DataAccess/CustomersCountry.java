package Assignment.Database.DataAccess;

import Assignment.Database.ConnectionHelper;
import Assignment.Database.Models.CustomerCountry;

import java.sql.*;
import java.util.ArrayList;


public class CustomersCountry {
    private String URL = ConnectionHelper.ConnectionURL;
    private Connection conn = null;

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
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            System.out.println("Please check your query");
            System.out.println(sqe.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception exception) {
                System.out.println("something went wrong while closing connection");
            }
        }
        return customersInCountry;
    }
}
