package com.scaler.productservicedecmwfeve.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This class will be service REST (HTTP) API's
@RestController
@RequestMapping("/hello")
public class HelloController {

    //The below function is called when we call /hello/say
    //something in curly braces becomes a variable as like name in Getmapping
    @GetMapping("/say/{name}/{times}")
    public String sayHello(@PathVariable("name") String name,
                           @PathVariable("times") int times) {
        String answer = "";
        for (int i = 0; i < times; i++) {
            answer += "Hello " + name;
            answer += "<br />";
        }
        return answer;
    }
}
