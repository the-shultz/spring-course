package pukteam.course.spring.mongodb;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import pukteam.course.spring.mongodb.model.Person;
import static org.springframework.data.mongodb.core.query.Criteria.where;

public class MongoApp {

    public static void main(String[] args) throws Exception {

        // spring eco system
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        MongoOperations mongoTemplate = ctx.getBean("mongoTemplate", MongoTemplate.class);
        mongoTemplate.insert(new Person("Moo", 47));

        Person personFromMongodb = mongoTemplate.findOne(new Query(where("name").is("Moo")), Person.class);
        System.out.println(personFromMongodb);

        // java based
        MongoOperations mongoOps = new MongoTemplate(new MongoClient(), "persons");
        mongoOps.insert(new Person("Joe", 34));

        System.out.println((mongoOps.findOne(new Query(where("name").is("Joe")), Person.class)));

        //mongoOps.dropCollection("person");
    }
}
