package pukteam.course.spring.imdb.annotation.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pukteam.course.spring.imdb.annotation.conf.MainConfiguration;
import pukteam.course.spring.imdb.annotation.conf.MovieConfiguration;
import pukteam.course.spring.imdb.dao.ActorDAO;
import pukteam.course.spring.imdb.dao.MovieDAO;
import pukteam.course.spring.imdb.model.Actor;
import pukteam.course.spring.imdb.model.Movie;
import pukteam.course.spring.imdb.service.api.IMDBService;

import java.util.List;
import java.util.Map;

public class RunImdbExample {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfiguration.class);
        ctx.registerShutdownHook();

        System.out.println("====== allActors =====");
        Map<String, Actor> actorMap = ctx.getBean("allActors", Map.class);
        System.out.println(actorMap.toString());

        System.out.println("====== Movie: mrsSmith =====");
        Movie mrsSmith = ctx.getBean("mrsSmith", Movie.class);
        System.out.println(mrsSmith);

        System.out.println("===== moviesDAO ====");
        MovieDAO moviesDAO = ctx.getBean("moviesDAO", MovieDAO.class);
        moviesDAO.getAllMovies().forEach(System.out::println);

        System.out.println("====== actorsDAO =====");
        ActorDAO actorDAO = ctx.getBean("actorsDAO", ActorDAO.class);
        actorDAO.getAllActors().forEach(System.out::println);

        System.out.println("======= MAIN DONE =======");
    }
}
