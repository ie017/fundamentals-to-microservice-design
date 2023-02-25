package com.example.customerservice.ReceiveConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RefreshScope /* that the bean (Class) will be refreshed with the latest values of the configuration.properties when the
 /actuator/refresh endpoint is triggered, allowing you to update the configuration of the bean at runtime without the need to restart the application*/
public class ReceiveSpringCloudConfigRestController {
   /* *//* Annotation @Value you can use it to inject the value of keycloak.auth-server-url for example in v1*//*
    @Value("${keycloak.auth-server-url}")
    private String v1;
    @Value("${keycloak.realm}")
    private String v2;
    @Value("${keycloak.resource}")
    private String v3;
    @Value("${keycloak.bearer-only}")
    private String v4;
    @Value("${keycloak.ssl-required}")
    private String v5;
    @GetMapping("/springcloudconfig")
    public Map<String, String> ReceiveConfig (){

        *//* You can use Map.of in java 17 to adding multiple key, value in the same time, but in java 8 u should
        insert key, value one by one*//*
        return Map.of("keycloak.auth-server-url", v1, "keycloak.realm" , v2, "keycloak.resource", v3, "keycloak.bearer-only", v4
        , "keycloak.ssl-required", v5);
    }*/

}
