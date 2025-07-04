package com.emailserver.service;

import com.emailserver.model.EmailRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class EmailServiceTest {

    private final EmailService emailService = new EmailService();

    @Test
    void testSendEmail_doesNotThrow() {
        EmailRequest request = new EmailRequest();
        request.setTo("tamer8@live.com");
        request.setFrom("battlefrogontherun@gmail.com");
        request.setBody("Test email body");

        assertDoesNotThrow(() -> emailService.sendEmail(request));
    }
}
