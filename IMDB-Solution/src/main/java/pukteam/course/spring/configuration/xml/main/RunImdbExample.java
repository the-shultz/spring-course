package pukteam.course.spring.configuration.xml.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pukteam.course.spring.imdb.dao.ActorDAO;
import pukteam.course.spring.imdb.service.api.IMDBService;

public class RunImdbExample {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
        ctx.registerShutdownHook();
        
        System.out.println("Showing actors before creating and initiating IMDB Service. each actor's ego is 0 as it wasn't calculated yet");
        ActorDAO actorDAO = ctx.getBean("actors-dao", ActorDAO.class);
        actorDAO.getAllActors().forEach(System.out::println);

        System.out.println("Creating and initiating IMDB Service that will calculate actors ego...");
        IMDBService imdbService = ctx.getBean("IMDBService", IMDBService.class);

        actorDAO.getAllActors().forEach(System.out::println);
    }
}
