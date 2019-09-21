package pukteam.course.spring.mongodb;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class AppConfig {

    /*
     * Use the standard Mongo driver API to create a com.mongodb.MongoClient instance.
     */
    @Bean
    public MongoClient mongoClient() {
        return new MongoClient("localhost");
    }


    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "persons");
    }
}