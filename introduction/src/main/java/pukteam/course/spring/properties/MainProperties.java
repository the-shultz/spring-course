package pukteam.course.spring.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

public class MainProperties {

    public static void main(String[] args) {

        System.out.println("Java properties (System)");
        System.getProperties().list(System.out);

        System.out.println("\nOS properties (env)");
        System.out.println(System.getenv().keySet());

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext
                ("ApplicationContext.xml");

        ConfigurableEnvironment environment = ctx.getEnvironment();

        System.out.println("\nUsing Spring Environment");
        System.out.println("Java Vendor: " + environment.getProperty("java.vendor"));
        System.out.println("NUMBER_OF_PROCESSORS: " + environment.getProperty("NUMBER_OF_PROCESSORS"));

        System.out.println("\nAdding custom properties");
        Map<String, Object> customProperties = new HashMap<>();
        customProperties.put("aProperty", "aValue");
        MutablePropertySources propertySources = environment.getPropertySources();
        propertySources.addLast(new MapPropertySource("customMap", customProperties));
        System.out.println("aProperty: " + environment.getProperty("aProperty"));

        System.out.println("\nAdding custom properties #2");
        customProperties = new HashMap<>();
        customProperties.put("aProperty", "aDifferentValue");
        customProperties.put("java.vendor", "NOT ORACLE");
        customProperties.put("NUMBER_OF_PROCESSORS", "80");
        propertySources.addFirst(new MapPropertySource("customMap2", customProperties));
        System.out.println("aProperty: " + environment.getProperty("aProperty"));
        System.out.println("Java Vendor: " + environment.getProperty("java.vendor"));
        System.out.println("NUMBER_OF_PROCESSORS: " + environment.getProperty("NUMBER_OF_PROCESSORS"));
    }
}
