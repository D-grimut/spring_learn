package spring_security.ch2_ss_notes.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloSpring {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello there";
    }
    
}
