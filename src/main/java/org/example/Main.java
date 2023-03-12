package org.example;
// Import required Spring Boot dependencies
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Define the main Spring Boot application class
@SpringBootApplication
@RestController
// Define the base path for all endpoints in this controller
@RequestMapping(path = "/api/bot")
public class Main {
    // Define main method that will run the application
        public static void main(String[] args) {
            SpringApplication.run(Main.class, args);
        }
        // Define an endpoint that will respond to GET requests to /api/bot/C
    @GetMapping("/C")
    public String test() {
        return "Working!!";
    }
   }
