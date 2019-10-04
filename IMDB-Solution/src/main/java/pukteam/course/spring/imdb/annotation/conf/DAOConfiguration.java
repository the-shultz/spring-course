package pukteam.course.spring.imdb.annotation.conf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pukteam.course.spring.imdb.dao.ActorDAO;
import pukteam.course.spring.imdb.dao.MovieDAO;
import pukteam.course.spring.imdb.model.Actor;
import pukteam.course.spring.imdb.model.Movie;

import java.util.Map;

@Configuration
public class DAOConfiguration {

    @Bean
    public MovieDAO moviesDAO(Map<String, Movie> allMovies) {
        MovieDAO movieDAO = new MovieDAO();
        movieDAO.setMovies(allMovies);
        return movieDAO;
    }

    @Bean
    public ActorDAO actorsDAO(Map<Integer, Actor> allActors) {
        return new ActorDAO(allActors);
    }
}
