package com.sripiranavan.java.springboot.project.onlinetestas.config;

import com.sripiranavan.java.springboot.project.onlinetestas.security.JpaClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    public AuthenticationManager authenticationManager;

    @Bean
    public JpaClientDetailsService jpaClientDetailsService(){
        return new JpaClientDetailsService();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(jpaClientDetailsService());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore())
                .accessTokenConverter(converter());
    }

    @Bean
    public TokenStore tokenStore(){
        return new JwtTokenStore(converter());
    }

    @Bean
    public JwtAccessTokenConverter converter(){
        var conv = new JwtAccessTokenConverter();
        KeyStoreKeyFactory keyFactory = new KeyStoreKeyFactory(
                new ClassPathResource("ssia.p12"),"testpass123".toCharArray()
        );
        conv.setKeyPair(keyFactory.getKeyPair("myKeyPair"));
        return conv;
//        keytool -genkey -keystore path\ssia.p12 -storetype pkcs12 -storepass testpass123 -keypass testpass123 -alias myKeyPair -keyalg RSA -validity 3650
    }
}
