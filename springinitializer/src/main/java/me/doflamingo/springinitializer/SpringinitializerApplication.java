package me.doflamingo.springinitializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringinitializerApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringinitializerApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

}
