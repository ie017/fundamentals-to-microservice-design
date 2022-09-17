package com.example.customerservice;

import com.example.customerservice.Customer.Customer;
import com.example.customerservice.Customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(new Customer(null, "ie017", "elorfissam1@gmail.com"));
            customerRepository.save(new Customer(null, "ie018", "elorfissam2@gmail.com"));
            customerRepository.save(new Customer(null, "ie019", "elorfissam3@gmail.com"));
            customerRepository.save(new Customer(null, "ie020", "elorfissam4@gmail.com"));
            customerRepository.findAll().forEach(customer -> {
                System.out.println(customer.getName());
            });
        };
    }

}
