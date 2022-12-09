/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pondasi.sch.id.pondasibungamayang.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pondasi.sch.id.pondasibungamayang.model.dto.request.EmailRequest;
import pondasi.sch.id.pondasibungamayang.service.EmailService;

/**
 *
 * @author Asus VivoBook
 */
@RestController
@RequestMapping("/email")
@AllArgsConstructor
public class EmailController {

    private EmailService emailService;

    @PostMapping
    public EmailRequest simpleMail(@RequestBody EmailRequest emailRequest) {
        return emailService.simpleEmail(emailRequest);
    }

    @PostMapping("/attach")
    public EmailRequest sendMessageWithAttachment(
            @RequestBody EmailRequest emailRequest
    ) {
        return emailService.sendMessageWithAttachment(emailRequest);
    }
}
