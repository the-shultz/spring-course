package pukteam.course.spring.imdb.dao;

import pukteam.course.spring.imdb.model.Movie;

import java.util.Collection;
import java.util.Map;

public class MovieDAO {

    private Map<String, Movie> movies;

    public void setMovies(Map<String, Movie> movies) {
        this.movies = movies;
    }

    public Collection<Movie> getAllMovies() {
        return movies.values();
    }
}
