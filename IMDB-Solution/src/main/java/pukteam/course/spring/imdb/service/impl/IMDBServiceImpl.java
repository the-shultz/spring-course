package pukteam.course.spring.imdb.service.impl;

import pukteam.course.spring.imdb.dao.ActorDAO;
import pukteam.course.spring.imdb.dao.MovieDAO;
import pukteam.course.spring.imdb.model.Actor;
import pukteam.course.spring.imdb.model.Movie;
import pukteam.course.spring.imdb.service.api.IMDBService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IMDBServiceImpl implements IMDBService {

    private ActorDAO actorDAO;
    private MovieDAO movieDAO;

    public IMDBServiceImpl(ActorDAO actorDAO, MovieDAO movieDAO) {
        this.actorDAO = actorDAO;
        this.movieDAO = movieDAO;
    }

    @Override
    public int totalDefinedMovies() {
        return movieDAO.getAllMovies().size();
    }

    @Override
    public int totalDefinedActors() {
        return actorDAO.getAllActors().size();
    }

    @Override
    public void init() {
        movieDAO
                .getAllMovies()
                .forEach(movie ->
                        movie
                            .getActorsInMovie().forEach(actor -> {
                                int movieRating = movie.getRating();
                                actor.addMovieRating(movieRating);
                            }));
    }

    @Override
    public Optional<Movie> getMovieByID(int movieId) {
        return movieDAO
                .getAllMovies()
                .stream()
                .filter(movie -> movie.getId() == movieId)
                .findFirst();

    }

    @Override
    public Optional<Actor> getActorByID(int actorId) {
        return actorDAO
                .getAllActors()
                .stream()
                .filter(actor -> actor.getId() == actorId)
                .findFirst();
    }

    @Override
    public List<Actor> getActorsOfMovie(int movieId) {

        // finds a movie with relevant ID. in case found (findFirst) maps to it's list of actors and returns them (or else returns empty list
        return movieDAO
                .getAllMovies()
                .stream()
                .filter(movie -> movie.getId() == movieId)
                .findFirst()
                .map(Movie::getActorsInMovie)
                .orElseGet(ArrayList::new);
    }

    @Override
    public List<Movie> getAllMoviesForActor(int actorId) {

        final List<Movie> movies = new ArrayList<>();
        // scan all movies, for each one of them extract its list of actors. if the relevant actor is there - add the movie to the result list...
        movieDAO
                .getAllMovies()
                .forEach(movie -> {
                    movie
                            .getActorsInMovie()
                            .stream()
                            .filter(actor -> actor.getId() == actorId)
                            .findFirst()
                            .ifPresent(actor -> movies.add(movie));
                });

        return movies;
    }
}
