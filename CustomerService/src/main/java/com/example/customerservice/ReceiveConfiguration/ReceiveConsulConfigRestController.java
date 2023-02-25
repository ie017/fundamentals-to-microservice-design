package com.example.customerservice.ReceiveConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@EnableConfigurationProperties(value = ConsulConfig.class)
public class ReceiveConsulConfigRestController {
    @Autowired
    private ConsulConfig consulConfig;

    @GetMapping("/consulconfig")
    public ConsulConfig ReceiveConfig(){
        return consulConfig;
    }
}
