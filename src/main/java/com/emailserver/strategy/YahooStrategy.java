package com.emailserver.strategy;

public class YahooStrategy implements EmailStrategy{
    @Override
    public String send() {
        return "Email sent via Yahoo";
    }
}
