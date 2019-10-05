package pukteam.course.spring.configuration.annotation.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pukteam.course.spring.imdb.bpp.DuplicationValidatorBeanPostProcessor;
import pukteam.course.spring.imdb.dao.ActorDAO;
import pukteam.course.spring.imdb.dao.MovieDAO;
import pukteam.course.spring.imdb.service.api.IMDBService;
import pukteam.course.spring.imdb.service.factory.IMDBServiceFactory;

@Configuration
@Import({MovieConfiguration.class, DAOConfiguration.class, ActorsConfiguration.class})
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
