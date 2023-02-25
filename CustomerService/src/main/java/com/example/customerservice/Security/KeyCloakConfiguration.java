/*
package com.example.customerservice.Security;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
public class KeyCloakConfiguration extends KeycloakWebSecurityConfigurerAdapter {
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        */
/* Pour definer la stratégie qui l'on va utiliser -> stratégie par défaut SessionRegistryImpl *//*

        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        */
/* Pour définir une authentification basée sur keycloak, keycloak qui va gérer les users et les roles*//*

        auth.authenticationProvider(keycloakAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/h2-console/**", "/actuator/refresh/**").permitAll();
        http.headers().frameOptions().disable();
        */
/* Pour dire qui chaque reqeute nécessaire une authentification*//*

        http.authorizeRequests().anyRequest().authenticated();
    }
}
*/
