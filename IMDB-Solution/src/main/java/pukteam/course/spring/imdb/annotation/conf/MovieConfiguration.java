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

import java.util.List;

@Configuration
//@ImportResource("actors-context.xml")
@Import(ActorsConfiguration.class)
public class MovieConfiguration {

    @Bean
    public Movie mrsSmith(@Qualifier("mrsSmithActors") List<Actor> movieActors) {
        Movie movie = new Movie(1, "Mr & Mrs Smith", Genre.ACTION);
        movie.setActorsInMovie(movieActors);
        movie.setRating(10);
        return movie;
    }

    @Bean
    public Movie oshens11(@Qualifier("oshen11Actors") List<Actor> movieActors) {
        Movie movie = new Movie(1, "Oshen 11", Genre.ACTION);
        movie.setActorsInMovie(movieActors);
        movie.setRating(5);
        return movie;
    }
}
