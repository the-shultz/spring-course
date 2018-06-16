package pukteam.course.spring.properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import pukteam.course.spring.di.impl.engine.V8Engine;
import pukteam.course.spring.di.impl.wheel.RaceWheel;
import pukteam.course.spring.di.impl.wheel.TerrainWheel;

public class MainProperties {

    public static void main(String[] args) {

                ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext
                ("ApplicationContext.xml");

        Environment environment = ctx.getEnvironment();
        System.out.println("Property property.c = " + environment.getProperty("property.c"));
        System.out.println("Property property.d = " + environment.getProperty("property.d"));

        V8Engine v8Engine = ctx.getBean("v8Engine", V8Engine.class);
        System.out.println(v8Engine);

        RaceWheel raceWheel = ctx.getBean("raceWheel", RaceWheel.class);
        System.out.println(raceWheel);

        TerrainWheel terrainWheel = ctx.getBean("terrainWheel", TerrainWheel.class);
        System.out.println(terrainWheel);

        ConfigFile configFile = ctx.getBean("configFile", ConfigFile.class);
        System.out.println("Config file value c = " + configFile.getValueC());
    }
}
