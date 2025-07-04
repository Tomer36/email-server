package com.emailserver.service;

import com.emailserver.model.EmailRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    void testSendEmail_doesNotThrow() {
        EmailRequest request = new EmailRequest();
        request.setTo("tamer8@live.com");
        request.setFrom("battlefrogontherun@gmail.com");
        request.setBody("Test email body");

        assertDoesNotThrow(() -> emailService.sendEmail(request));
    }
}
