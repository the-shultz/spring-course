package pukteam.course.spring.imdb.annotation.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import pukteam.course.spring.imdb.model.Actor;
import pukteam.course.spring.imdb.model.Genre;
import pukteam.course.spring.imdb.model.Movie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class MovieConfiguration {

    @Autowired
    @Qualifier("mrsSmithActors") List<Actor> mrsSmithActors;

    @Autowired
    @Qualifier("oshen11Actors") List<Actor> oshen11actors;

    @Bean
    public Movie mrsSmith() {
        Movie movie = new Movie(1, "Mr & Mrs Smith", Genre.ACTION);
        movie.setActorsInMovie(mrsSmithActors);
        movie.setRating(10);
        return movie;
    }

    @Bean
    public Movie oshens11() {
        Movie movie = new Movie(2, "Oshen 11", Genre.ACTION);
        movie.setActorsInMovie(oshen11actors);
        movie.setRating(5);
        return movie;
    }

    @Bean
    public Map<String, Movie> allMovies() {
        Map<String, Movie> moviesMap = new HashMap<>();
        moviesMap.put("Oshen 11", oshens11());
        moviesMap.put("Mrs Smith", mrsSmith());
        return moviesMap;
    }
}
