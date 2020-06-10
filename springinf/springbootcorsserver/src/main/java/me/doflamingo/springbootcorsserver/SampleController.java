package me.doflamingo.springbootcorsserver;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:18080")
@RestController
public class SampleController {

    @GetMapping("/hello")
    public String hello() {
//        Hello hello = new Hello();
//
//        hello.setPrefix("Hey,");
//        hello.setName("Doflamingo");

        return "hello";
    }
}
