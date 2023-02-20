package com.example.billingservice.Product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.QueryParam;

/* Cette interface permet de connecter avec le microservice PRODUCT-SERVICE*/

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductItemRestClient {
    @GetMapping(path = "/produits")/*Peut retourner la page des produits avec le size spécifié et aussi le nombre de la page*/
    PagedModel<Product> pageProducts(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size);

    @GetMapping(path = "/produits/{id}") /* Pour récupérer le produit via le service PRODUCT-SERVICE */
    Product getProduct(@PathVariable(name = "id") String id);
}