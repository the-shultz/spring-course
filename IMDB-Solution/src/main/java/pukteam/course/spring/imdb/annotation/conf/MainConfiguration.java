package pukteam.course.spring.imdb.annotation.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import pukteam.course.spring.imdb.bpp.DuplicationValidatorBeanPostProcessor;
import pukteam.course.spring.imdb.dao.ActorDAO;
import pukteam.course.spring.imdb.dao.MovieDAO;
import pukteam.course.spring.imdb.service.api.IMDBService;
import pukteam.course.spring.imdb.service.factory.IMDBServiceFactory;

@Configuration
@Import({MovieConfiguration.class, DAOConfiguration.class, ActorsConfiguration.class})
//@ImportResource("actors-context.xml")
public class MainConfiguration {

    @Bean
    public IMDBService imdbService(ActorDAO actorDAO, MovieDAO movieDAO) {
        return IMDBServiceFactory.getInstance().getIMDBService(actorDAO, movieDAO);
    }

    @Bean
    public DuplicationValidatorBeanPostProcessor duplicationValidatorBeanPostProcessor() {
        return new DuplicationValidatorBeanPostProcessor();
    }
}
