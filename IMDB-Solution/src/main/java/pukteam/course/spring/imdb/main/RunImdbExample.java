package pukteam.course.spring.imdb.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pukteam.course.spring.imdb.model.Movie;

public class RunImdbExample {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");

        Movie mrsSmith = ctx.getBean("mrs-smith", Movie.class);
        Movie oshen11 = ctx.getBean("oshen-11", Movie.class);

        System.out.println(mrsSmith);
        System.out.println(oshen11);
    }
}
