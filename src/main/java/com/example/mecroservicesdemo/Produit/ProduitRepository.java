package com.example.mecroservicesdemo.Produit;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource // Pour utiliser spring data rest
public interface ProduitRepository extends MongoRepository<Produit, String> {

}

/* Spring data rest utilise les bonnes pratiques, C'est-à-dire il créera les references entre les apis
* aussi il aura donne la possibilité de spécifié la page et le nombres des objets d'un chaque page, on
* peut aussi de faire des triés*/