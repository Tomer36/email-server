package com.emailserver.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailRequest {
    @NotBlank(message = "Recipient email 'to' cannot be blank")
    @Email(message = "Recipient email 'to' must be a valid email address")
    private String to;

    @NotBlank(message = "Sender email 'from' cannot be blank")
    @Email(message = "Sender email 'from' must be a valid email address")
    private String from;

    private String subject; // Optional, but you can validate if you want

    @NotBlank(message = "Email body cannot be blank")
    private String body;

    // Getters and setters...
    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }

    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }
}
