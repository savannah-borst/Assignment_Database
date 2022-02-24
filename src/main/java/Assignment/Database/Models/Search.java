package Assignment.Database.Models;

public class Search {
    //Fields
    private String track;
    private String artist;
    private String albumName;
    private String GenreName;

    //Constructor
    public Search(String track, String artist, String albumName, String genreName) {
        this.track = track;
        this.artist = artist;
        this.albumName = albumName;
        GenreName = genreName;
    }

    //Getters and Setters
    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getGenreName() {
        return GenreName;
    }

    public void setGenreName(String genreName) {
        GenreName = genreName;
    }
}
