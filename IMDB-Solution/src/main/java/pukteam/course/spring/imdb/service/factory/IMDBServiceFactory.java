package pukteam.course.spring.imdb.service.factory;

import pukteam.course.spring.imdb.dao.ActorDAO;
import pukteam.course.spring.imdb.dao.MovieDAO;
import pukteam.course.spring.imdb.service.api.IMDBService;
import pukteam.course.spring.imdb.service.impl.IMDBServiceImpl;

public class IMDBServiceFactory {

    private IMDBServiceFactory() {};
    private static IMDBServiceFactory factory = new IMDBServiceFactory();

    public static IMDBServiceFactory getInstance() {
        return factory;
    }

    public IMDBService getIMDBService(ActorDAO actorDAO, MovieDAO movieDAO) {
        return new IMDBServiceImpl(actorDAO, movieDAO);
    }
}
