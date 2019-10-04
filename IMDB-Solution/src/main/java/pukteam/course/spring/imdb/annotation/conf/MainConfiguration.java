package pukteam.course.spring.imdb.annotation.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MovieConfiguration.class, DAOConfiguration.class})
public class MainConfiguration {
}
