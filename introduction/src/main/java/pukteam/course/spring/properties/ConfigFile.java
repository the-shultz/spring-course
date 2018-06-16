package pukteam.course.spring.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:app2.properties")
public class ConfigFile {

    @Value("${property.c}")
    private String valueC;

    public String getValueC() {
        return valueC;
    }
}
