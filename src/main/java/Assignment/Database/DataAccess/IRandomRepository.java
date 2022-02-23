package Assignment.Database.DataAccess;

import Assignment.Database.Models.RandomArtist;
import Assignment.Database.Models.RandomGenre;
import Assignment.Database.Models.RandomSong;

import java.util.ArrayList;

public interface IRandomRepository {
    public ArrayList<RandomArtist> randomArtists();
    public ArrayList<RandomSong> randomSongs();
    public ArrayList<RandomGenre> randomGenres();
}
