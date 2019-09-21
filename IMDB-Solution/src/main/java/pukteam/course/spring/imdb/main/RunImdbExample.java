package pukteam.course.spring.imdb.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pukteam.course.spring.imdb.dao.ActorDAO;
import pukteam.course.spring.imdb.dao.MovieDAO;
import pukteam.course.spring.imdb.model.Actor;
import pukteam.course.spring.imdb.model.Movie;

import java.util.Collection;

public class RunImdbExample {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");

        ActorDAO actorDAO = ctx.getBean("actors-dao", ActorDAO.class);
        Collection<Actor> allActors = actorDAO.getAllActors();
        System.out.println("\nActors:");
        System.out.println("=======");
        allActors.forEach(System.out::println);

        MovieDAO movieDAO = ctx.getBean("movies-dao", MovieDAO.class);
        Collection<Movie> allMovies = movieDAO.getAllMovies();
        System.out.println("\nMovies:");
        System.out.println("=======");
        allMovies.forEach(System.out::println);
    }
}
