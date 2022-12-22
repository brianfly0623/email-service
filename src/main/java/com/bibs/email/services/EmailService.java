package com.bibs.email.services;

import com.bibs.email.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service é a camada intermediária entre o Repository e o Controller
@Service
public class EmailService {

    // ponto de injeção de repository para conseguir criar os métodos para fazer a persistência com o banco
    @Autowired
    EmailRepository emailRepository;
}
