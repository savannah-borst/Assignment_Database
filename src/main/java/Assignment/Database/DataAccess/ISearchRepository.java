package Assignment.Database.DataAccess;

import Assignment.Database.Models.Search;

import java.util.ArrayList;

public interface ISearchRepository {
    public ArrayList<Search> getSearch(String searchQuery);
}
