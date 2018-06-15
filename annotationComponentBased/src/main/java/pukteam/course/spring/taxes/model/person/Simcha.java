package pukteam.course.spring.taxes.model.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pukteam.course.spring.taxes.model.Counter;
import pukteam.course.spring.taxes.model.Gender;
import pukteam.course.spring.taxes.model.Person;
import pukteam.course.spring.taxes.model.Status;

import javax.annotation.PostConstruct;

@Component
public class Simcha extends Person {

    @Autowired
    private Counter counter;

    public Simcha() {
        super(3, 40000);
        this.setAge(25);
        this.setGender(Gender.FEMALE);
        this.setStatus(Status.SINGLE);
    }

    @PostConstruct
    void init() {
        if (counter != null) {
            this.setCounter(counter);
        } else {
            this.setCounter(new Counter());
        }
    }

}
