package com.emailserver.strategy;

public class WallaStrategy implements EmailStrategy{
    @Override
    public String send() {
        return "Email sent via walla";
    }
}
