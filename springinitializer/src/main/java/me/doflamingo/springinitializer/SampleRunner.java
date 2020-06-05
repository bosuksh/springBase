package me.doflamingo.springinitializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
@Component
public class SampleRunner implements ApplicationRunner {

    @Autowired
    DoflaProperties doflaProperties;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("========================");
        System.out.println(doflaProperties.getName());
        System.out.println(doflaProperties.getAge());
        System.out.println(doflaProperties.getFullName());
        System.out.println("========================");

    }
}
