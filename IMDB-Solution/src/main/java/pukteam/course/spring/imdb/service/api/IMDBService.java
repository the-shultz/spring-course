package pukteam.course.spring.imdb.service.api;

import pukteam.course.spring.imdb.model.Actor;
import pukteam.course.spring.imdb.model.Movie;

import java.util.List;
import java.util.Optional;

public interface IMDBService {
    int totalDefinedMovies();
    int totalDefinedActors();
    void init();
    Optional<Movie> getMovieByID(int movieId);
    Optional<Actor> getActorByID(int actorId);
    List<Actor> getActorsOfMovie(int movieId);
    List<Movie> getAllMoviesForActor(int actorId);
}
