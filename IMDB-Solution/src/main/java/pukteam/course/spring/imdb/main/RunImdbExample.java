package pukteam.course.spring.imdb.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pukteam.course.spring.imdb.model.Actor;

public class RunImdbExample {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");

        Actor julia = ctx.getBean("julia-Roberts", Actor.class);
        Actor brad = ctx.getBean("brad-pitt", Actor.class);

        System.out.println(julia);
        System.out.println(brad);
    }
}
