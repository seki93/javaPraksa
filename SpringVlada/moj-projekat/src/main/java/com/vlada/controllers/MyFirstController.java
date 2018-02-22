package com.vlada.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
 

public class MyFirstController {

	@RequestMapping("/home")     //Request mapping https://localhost/home
    String myHome() {
        return "Hello World!";
    }
}
