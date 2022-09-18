package com.example.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    //@Bean
    /* Pour spécifier les routes on peut utiliser l'objet RouteLocatorBuilder,
    * Aussi avec l'utilisation de cette technique il faut désactiver l'utilisation de eureka service (Registration service)*/
    RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route((r)-> r.path("/customers/**").uri("http://localhost:9091/"))
                .route((r)-> r.path("/produits/**").uri("http://localhost:9090/"))
                .build();
    }

    /* Généralement les deux precedents méthodes sont utilisées dans le cas si ona un peu des services, et si on connaît les uri des services, pour
    * le mieux travail on peut utiliser le service eureka avec le code suivant :*/
    @Bean
    /* Avec cette implémentation je demande si une fois le gateway reçoit une requete il regarde dans l'url de la requete et il prend le nom
    * de microservice après avec l'utilisation de registration service eureka gateway connait aux se trouve le microservice (port, @IP qui sont spécifié dans eureka)
    * et rediriger cette requete vers ce microservice*/
    DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient reactiveDiscoveryClient,
                                                        DiscoveryLocatorProperties discoveryLocatorProperties){
        return new DiscoveryClientRouteDefinitionLocator(reactiveDiscoveryClient,discoveryLocatorProperties);
    }
}
/* Don't use the underscore in the names of microservices because that make your host invalid*/