package com.emailserver.service;

import com.emailserver.factory.EmailStrategyFactory;
import com.emailserver.model.EmailRequest;
import com.emailserver.strategy.EmailStrategy;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    //    EmailStrategy strategy;
//    public void sendEmail(EmailRequest request){
//        if (request.getFrom().toLowerCase().endsWith("@gmail.com")) {
//            strategy = new GmailStrategy();
//        }
//        else if (request.getFrom().toLowerCase().endsWith("@yahoo.com")) {
//            strategy = new YahooStrategy();
//        }
//        else if (request.getFrom().toLowerCase().endsWith("@walla.com")) {
//            strategy = new WallaStrategy();
//        }
//
//        else strategy = null;
//
//        if(strategy != null){
//            strategy.send();
//        }
//
//        else
//            System.out.println("Invalid Email Address");
//    }
    public String sendEmail(EmailRequest request) {
        System.out.println(request.getFrom());
        EmailStrategy strategy = EmailStrategyFactory.getStrategy(request.getFrom());
        if (strategy != null) {
            return strategy.send();
        }
        return "Failed";
    }
}
