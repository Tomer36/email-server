package com.emailserver.strategy;

public class GmailStrategy implements EmailStrategy{
    @Override
    public String send() {
        return "Email sent via Gmail";
    }
}
