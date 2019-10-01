package pukteam.course.spring.imdb.dao;

import pukteam.course.spring.imdb.model.Actor;

import javax.annotation.PreDestroy;
import java.util.Collection;
import java.util.Map;

public class ActorDAO {

    private Map<Integer, Actor> actors;

    public ActorDAO(Map<Integer, Actor> actors) {
        this.actors = actors;
    }

    public Collection<Actor> getAllActors() {
        return actors.values();
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println("About to destroy Actors DAO...");
    }
}
