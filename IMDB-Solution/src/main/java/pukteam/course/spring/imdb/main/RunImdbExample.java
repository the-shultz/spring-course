package pukteam.course.spring.imdb.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pukteam.course.spring.imdb.model.Actor;
import pukteam.course.spring.imdb.service.api.IMDBService;

import java.util.List;

public class RunImdbExample {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");

        IMDBService imdbService = ctx.getBean("IMDBService", IMDBService.class);
        imdbService.init();

        imdbService
                .getMovieByID(1)
                .ifPresent(movie -> {
                    System.out.println("Actors of movie 1:" + movie);
                    List<Actor> actorsOfMovie = imdbService.getActorsOfMovie(1);
                    actorsOfMovie.forEach(System.out::println);
                });

        imdbService.getActorByID(3).ifPresent(actor -> {
            System.out.println("All movies of actor " + actor);
            imdbService.getAllMoviesForActor(3).forEach(System.out::println);
        });
    }
}
