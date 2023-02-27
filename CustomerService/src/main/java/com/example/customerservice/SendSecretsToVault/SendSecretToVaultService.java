package com.example.customerservice.SendSecretsToVault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultTemplate;

import java.util.Map;

@Service
public class SendSecretToVaultService {
    /* VaultTemplate is an interface used to do operations on vault like
    creation token, secret and send it to vault */
    @Autowired
    private VaultTemplate vaultTemplate;

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            vaultTemplate.opsForVersionedKeyValue("secret")
                    .put("product-service", Map.of("product.id", "PHC1234P", "product.access","ie017-forProduct"));
        };
    }
}
