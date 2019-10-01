package pukteam.course.spring.imdb.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import pukteam.course.spring.imdb.model.Actor;
import pukteam.course.spring.imdb.model.Movie;

import java.util.HashSet;
import java.util.Set;

public class DuplicationValidatorBeanPostProcessor implements BeanPostProcessor {

    private Set<Integer> moviesIds;
    private Set<Integer> actorsIds;

    public DuplicationValidatorBeanPostProcessor() {
        moviesIds = new HashSet<>();
        actorsIds = new HashSet<>();
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof Movie) {
            int id = ((Movie) bean).getId();
            if (moviesIds.contains(id)) {
                String message = "Found duplicate Movie ID ! " + id;
                System.out.println(message);
                throw new BeanCreationException(message);
            } else {
                moviesIds.add(id);
            }
        }

        if (bean instanceof Actor) {
            int id = ((Actor) bean).getId();
            if (actorsIds.contains(id)) {
                String message = "Found duplicate Actor ID ! " + id;
                System.out.println(message);
                throw new BeanCreationException(message);
            } else {
                actorsIds.add(id);
            }
        }

        return bean;
    }
}
