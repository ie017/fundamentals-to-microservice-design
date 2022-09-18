package com.example.billingservice.Customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/* Cette interface peprmet de connecter avec le microservice CUSTOMER-SERVICE via l'utilisation
* de l'annotation FeignClient*/

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping(path = "/customers/{id}") /*Je demande à OpenFein si j'appelle la méthode getCustomerById avec l'id,
     tu m'envoies la requete vers le service CUSTOMER-SERVICE avec get*/
    Customer getCustomerById(@PathVariable(name = "id") Long id);

}
