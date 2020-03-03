package com.mycompany.rest.webservices.restfulwebservices;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {

    //GET
    //URI - /hello-world
    //method
    @GetMapping(path="/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
}