package com.emailserver.strategy;

import com.emailserver.model.EmailRequest;
import com.emailserver.model.VendorConfig;
import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Properties;

public abstract class EmailStrategy {
    protected final VendorConfig vendorConfig;

    public EmailStrategy(VendorConfig vendorConfig) {
        this.vendorConfig = vendorConfig;
    }

    public void send(EmailRequest request) {
        try {
            System.out.println("Sending email on thread: " + Thread.currentThread().getName());
            sendViaSMTP(request);
            System.out.println("[" + getClass().getSimpleName() + "] Real email sent successfully from " +
                    request.getFrom() + " to " + request.getTo());
        } catch (MessagingException e) {
            System.out.println("[" + getClass().getSimpleName() + " MOCK SEND] Would send from " +
                    request.getFrom() + " to " + request.getTo() + ": " + request.getBody());
            System.out.println("[" + getClass().getSimpleName() + " MOCK] Reason for fallback: " + e.getMessage());
        }
    }

    protected void sendViaSMTP(EmailRequest request) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", vendorConfig.getSmtpServer());
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(vendorConfig.getUsername(), vendorConfig.getPassword());
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(request.getFrom()));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(request.getTo()));
        message.setSubject("Bridge Email");
        message.setText(request.getBody());
        Transport.send(message);
    }
}

