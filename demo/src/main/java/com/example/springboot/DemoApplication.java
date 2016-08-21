package com.example.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.springboot.model.Customer;
import com.example.springboot.repositories.CustomerRepository;
import com.github.javafaker.Faker;

/**
 * Class to start the spring boot REST APP
 * @author SahniH
 *
 */
@SpringBootApplication
public class DemoApplication {

    private final Faker faker = new Faker();

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner initializeDb(CustomerRepository repository) {
        return (args) -> {
            repository.deleteAll();

            for (int i = 0; i < 20; i++) {
                repository.save(new Customer(faker.lorem().word(), faker.lorem().sentence()));
            }
        };
    }
}
