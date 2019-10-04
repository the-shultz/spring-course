package pukteam.course.spring.imdb.annotation.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pukteam.course.spring.imdb.annotation.conf.MainConfiguration;
import pukteam.course.spring.imdb.annotation.conf.MovieConfiguration;
import pukteam.course.spring.imdb.dao.ActorDAO;
import pukteam.course.spring.imdb.model.Actor;
import pukteam.course.spring.imdb.model.Movie;
import pukteam.course.spring.imdb.service.api.IMDBService;

import java.util.List;
import java.util.Map;

public class RunImdbExample {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfiguration.class);
        ctx.registerShutdownHook();
        
        System.out.println("Showing actors before creating and initiating IMDB Service. each actor's ego is 0 as it wasn't calculated yet");
        Map<String, Actor> actorMap = ctx.getBean("allActors", Map.class);
        System.out.println(actorMap.toString());

        Movie mrsSmith = ctx.getBean("mrsSmith", Movie.class);
        System.out.println(mrsSmith);
    }
}
