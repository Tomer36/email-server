package com.emailserver.service;

import com.emailserver.factory.EmailStrategyFactory;
import com.emailserver.model.EmailRequest;
import com.emailserver.strategy.EmailStrategy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Async
    public void sendEmail(EmailRequest request) {
        EmailStrategy strategy = EmailStrategyFactory.getStrategy(request.getFrom());
        strategy.send(request);
    }
}
