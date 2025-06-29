package com.emailserver.controller;

import com.emailserver.model.EmailRequest;
import com.emailserver.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String test(){
        return "Server is UP";
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        try {
            String resultMessage = emailService.sendEmail(request);
            System.out.println(resultMessage);
            return ResponseEntity.ok(resultMessage);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error sending email" + e.getMessage());
        }
    }
}
