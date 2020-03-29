package com.bosuksh.springapplicationcontext;

import com.bosuksh.out.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import sun.net.www.content.text.Generic;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    MyService myService;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.addInitializers((ApplicationContextInitializer<GenericApplicationContext>) ctx -> {
            ctx.registerBean(MyService.class);
            ctx.registerBean(ApplicationRunner.class, ()-> args1 -> System.out.println("Functional Bean Definition!!"));
        });
        app.run(args);
    }

}
