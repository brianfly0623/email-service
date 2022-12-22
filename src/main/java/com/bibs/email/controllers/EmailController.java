package com.bibs.email.controllers;

import com.bibs.email.dtos.EmailDto;
import com.bibs.email.models.EmailModel;
import com.bibs.email.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    // ponto de injeção do EmailService
    @Autowired
    EmailService emailService;

    // método post que recebe dto de entrada, faz validação e passa o dto para o model (para salvar e enviar o e-mail)
    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel); // método faz a conversão de DTO pra Model
        emailService.sendEmail(emailModel); // envio
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED); // retorna o model e o status
    }

}
