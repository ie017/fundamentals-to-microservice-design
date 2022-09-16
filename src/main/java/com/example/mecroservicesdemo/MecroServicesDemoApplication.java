package com.example.mecroservicesdemo;

import com.example.mecroservicesdemo.Produit.Produit;
import com.example.mecroservicesdemo.Produit.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Repository;

@SpringBootApplication
public class MecroServicesDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MecroServicesDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProduitRepository produitRepository){
        return args -> {
            produitRepository.save(new Produit("Galaxy S3", 1000, 4));
            produitRepository.save(new Produit("Galaxy S5", 1800, 14));
            produitRepository.save(new Produit("Galaxy S9", 4000, 30));
            produitRepository.findAll().forEach(p->{
                System.out.println(p.getName());
            });
        };
    }

}


