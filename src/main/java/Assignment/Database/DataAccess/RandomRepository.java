package Assignment.Database.DataAccess;

import Assignment.Database.Models.RandomArtist;
import Assignment.Database.Models.RandomGenre;
import Assignment.Database.Models.RandomSong;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RandomRepository implements IRandomRepository{
    private final String URL = ConnectionHelper.ConnectionURL;
    private Connection conn = null;

    public ArrayList<RandomArtist> randomArtists() {
        ArrayList<RandomArtist> randomArtist = new ArrayList<>();

        try {
            //Connect to database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook has been established.");

            //Query 5 random artists
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT Name FROM Artist ORDER BY RANDOM() LIMIT 5");

            //Execute statement
            ResultSet resultSet = preparedStatement.executeQuery();

            //Process Results
            while (resultSet.next()) {
                randomArtist.add(
                        new RandomArtist(
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
        return randomArtist;
    }

    public ArrayList<RandomSong> randomSongs() {
        ArrayList<RandomSong> randomSong = new ArrayList<>();

        try {
            //Connect to database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook has been established.");

            //Query 5 random songs
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT Name FROM Track ORDER BY RANDOM() LIMIT 5");

            //Execute statement
            ResultSet resultSet = preparedStatement.executeQuery();

            //Process Results
            while (resultSet.next()) {
                randomSong.add(
                        new RandomSong(
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
        return randomSong;
    }

    public ArrayList<RandomGenre> randomGenres() {
        ArrayList<RandomGenre> randomGenre = new ArrayList<>();

        try {
            //Connect to database
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to Chinook has been established.");

            //Query 5 random songs
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT Name FROM Genre ORDER BY RANDOM() LIMIT 5");

            //Execute statement
            ResultSet resultSet = preparedStatement.executeQuery();

            //Process Results
            while (resultSet.next()) {
                randomGenre.add(
                        new RandomGenre(
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
        return randomGenre;
    }
}
