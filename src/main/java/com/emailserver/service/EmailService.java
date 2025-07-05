package com.emailserver.service;
import com.emailserver.factory.EmailStrategyFactory;
import com.emailserver.model.EmailRequest;
import com.emailserver.strategy.EmailStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final EmailStrategyFactory emailStrategyFactory;

    @Autowired
    public EmailService(EmailStrategyFactory emailStrategyFactory) {
        this.emailStrategyFactory = emailStrategyFactory;
    }

    @Async
    public void sendEmail(EmailRequest request) {
        EmailStrategy strategy = emailStrategyFactory.getStrategy(request.getFrom());
        strategy.send(request);
    }
}
