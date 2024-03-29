package com.example.customerservice.ReceiveConfiguration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
/*Pour prendre les proprieties qui débuter par value dans notre file : customer-service dans consul*/
@ConfigurationProperties(prefix = "value")
@Data
public class ConsulConfig {
    /* Les variables doivent avoir les memes nomes qui sont dans consul */
    private String username;
    private String password;
}
