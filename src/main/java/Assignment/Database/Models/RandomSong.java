package Assignment.Database.Models;

public class RandomSong {
    //Fields
    private String Song;

    //Constructor
    public RandomSong(String Song) {
        this.Song = Song;
    }

    //Getters and Setters
    public String getSong() {
        return Song;
    }

    public void setSong(String Song) {
        this.Song = Song;
    }
}
