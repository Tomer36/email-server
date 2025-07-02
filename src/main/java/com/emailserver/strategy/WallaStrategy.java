package com.emailserver.strategy;

import com.emailserver.config.VendorConfiguration;
import com.emailserver.model.EmailRequest;
import com.emailserver.model.VendorConfig;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class WallaStrategy implements EmailStrategy {
    @Override
    public void send(EmailRequest request) {
        VendorConfig config = VendorConfiguration.getConfig("walla.co.il");
        sendViaSMTP(config, request);
    }

    private void sendViaSMTP(VendorConfig config, EmailRequest request) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", config.getSmtpServer());
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(config.getUsername(), config.getPassword());
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(request.getFrom()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(request.getTo()));
            message.setSubject("Bridge Email");
            message.setText(request.getBody());
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
