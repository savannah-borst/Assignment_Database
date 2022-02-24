package Assignment.Database.DataAccess;

import Assignment.Database.Models.Search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SearchRepository implements ISearchRepository {
    private final String URL = ConnectionHelper.ConnectionURL;
    private Connection conn = null;

    public ArrayList<Search> getSearch(String searchQuery) {
        ArrayList<Search> search = new ArrayList<>();
        //searchQuery split?

        try {
            //Connect to database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook has been established.");

            //Make query for search
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT Track.Name, Art.Name, Alb.Title, G.Name FROM Track\n" +
                    "    JOIN Album Alb on Track.AlbumId = Alb.AlbumId\n" +
                    "    JOIN Artist Art on Alb.ArtistId = Art.ArtistId\n" +
                    "    JOIN Genre G on Track.GenreId = G.GenreId\n" +
                    "WHERE Track.Name LIKE ?");

            preparedStatement.setString(1, "%" + searchQuery + "%");

            //Execute statement
            ResultSet resultSet = preparedStatement.executeQuery();

            //Process Result
            while (resultSet.next()) {
                search.add(
                        new Search(
                                resultSet.getString("Name"),
                                resultSet.getString("Name"),
                                resultSet.getString("Title"),
                                resultSet.getString("Name")
                        )
                );
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
        return search;
    }
}
