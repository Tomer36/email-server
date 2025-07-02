package com.emailserver.strategy;

import com.emailserver.model.EmailRequest;

public interface EmailStrategy {
    public void send(EmailRequest request);
}
