package com.example.customerservice.ReceiveConfiguration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
/* With this propertie ConfigurationProperties we don't need refreshScope annotation */
@ConfigurationProperties(prefix = "connect-db")
@Data
public class VaultConfig {
    private String username;
    private String password;
}
