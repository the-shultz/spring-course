package pukteam.spring.course.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import pukteam.spring.course.mongodb.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);

}
