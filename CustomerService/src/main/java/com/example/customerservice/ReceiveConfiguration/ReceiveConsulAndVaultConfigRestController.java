package com.example.customerservice.ReceiveConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties(value = {ConsulConfig.class, VaultConfig.class})
public class ReceiveConsulAndVaultConfigRestController {
    @Autowired
    private ConsulConfig consulConfig;
    @Autowired
    private VaultConfig vaultConfig;

    @GetMapping("/consulconfig")
    public ConsulConfig ReceiveCondulConfig(){
        return consulConfig;
    }

    @GetMapping("/vaultconfig")
    public VaultConfig ReceiveVaultConfig(){
        return vaultConfig;
    }
}
