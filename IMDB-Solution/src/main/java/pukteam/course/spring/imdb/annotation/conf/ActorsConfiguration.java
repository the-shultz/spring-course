package pukteam.course.spring.imdb.annotation.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import pukteam.course.spring.imdb.model.Actor;
import pukteam.course.spring.imdb.model.EgoMetrics;
import pukteam.course.spring.imdb.model.Gender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ActorsConfiguration {

    @Bean
    public Actor bradPitt() {
        Actor actor = new Actor();
        actor.setAge(33);
        actor.setGender(Gender.MALE);
        actor.setId(1);
        actor.setEgoMetrics(egoMetrics());
        return actor;
    }

    @Bean
    public Actor georgeClooney() {
        Actor actor = new Actor();
        actor.setAge(55);
        actor.setGender(Gender.MALE);
        actor.setId(2);
        actor.setEgoMetrics(egoMetrics());
        return actor;
    }

    @Bean
    public Actor juliaRoberts() {
        Actor actor = new Actor();
        actor.setAge(44);
        actor.setGender(Gender.FEMALE);
        actor.setId(3);
        actor.setEgoMetrics(egoMetrics());
        return actor;
    }

    @Bean
    @Scope(value = "prototype")
    public EgoMetrics egoMetrics() {
        return new EgoMetrics();
    }

    @Bean
    public List<Actor> oshen11Actors() {
        List<Actor> actors = new ArrayList<>();
        actors.add(georgeClooney());
        actors.add(juliaRoberts());
        actors.add(bradPitt());
        return actors;
    }

    @Bean
    public List<Actor> mrsSmithActors() {
        List<Actor> actors = new ArrayList<>();
        actors.add(juliaRoberts());
        actors.add(bradPitt());
        return actors;
    }

    @Bean
    public Map<String, Actor> allActors() {
        Map<String, Actor> actorsMap = new HashMap<>();
        actorsMap.put("Julia", juliaRoberts());
        actorsMap.put("Brad", bradPitt());
        actorsMap.put("George", georgeClooney());
        return actorsMap;
    }

}
