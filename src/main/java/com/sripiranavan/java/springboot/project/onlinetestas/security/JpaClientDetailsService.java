package com.sripiranavan.java.springboot.project.onlinetestas.security;

import com.sripiranavan.java.springboot.project.onlinetestas.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

public class JpaClientDetailsService implements ClientDetailsService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        return clientRepository.findClientByClientId(s).map(
                c -> new SecurityClient(c)
        ).orElseThrow(() -> new ClientRegistrationException("Client not found"));
    }
}
