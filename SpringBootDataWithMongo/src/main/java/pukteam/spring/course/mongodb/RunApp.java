package pukteam.spring.course.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import pukteam.spring.course.mongodb.MongoDataUpdater;


public class RunApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MongoDataUpdater.class, args);
    }
}
