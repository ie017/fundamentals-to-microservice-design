package com.example.customerservice;

import com.example.customerservice.Customer.Customer;
import com.example.customerservice.Customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    /* L'objet RepositoryRestConfiguration utiliser pour appliquer des configurations au niveau des rest qui sont implémentées par spring
    * data rest*/
    CommandLineRunner runner(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Customer.class);
        return args -> {
            customerRepository.save(new Customer(null, "ie017", "elorfissam1@gmail.com"));
            customerRepository.save(new Customer(null, "ie018", "elorfissam2@gmail.com"));
            customerRepository.save(new Customer(null, "ie019", "elorfissam3@gmail.com"));
            customerRepository.save(new Customer(null, "ie020", "elorfissam4@gmail.com"));
            customerRepository.save(new Customer(null, "ie021", "elorfissam5@gmail.com"));
            customerRepository.save(new Customer(null, "ie022", "elorfissam6@gmail.com"));
            customerRepository.save(new Customer(null, "ie023", "elorfissam4@gmail.com"));
            customerRepository.save(new Customer(null, "ie024", "elorfissam4@gmail.com"));
            customerRepository.save(new Customer(null, "ie025", "elorfissam4@gmail.com"));
            customerRepository.findAll().forEach(customer -> {
                System.out.println(customer.getName());
            });
        };
    }

}
