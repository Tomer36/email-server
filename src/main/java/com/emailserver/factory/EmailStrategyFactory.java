package com.emailserver.factory;

import com.emailserver.strategy.*;

public class EmailStrategyFactory {

//    public static EmailStrategy getStrategy(String email) {
//        if (email.toLowerCase().endsWith("@gmail.com")) {
//            return new GmailStrategy();
//        }
//        else if (email.toLowerCase().endsWith("@yahoo.com")) {
//            return new YahooStrategy();
//        }
//        else if (email.toLowerCase().endsWith("@walla.com")) {
//            return new WallaStrategy();
//        } else return null;
//    }

    public static EmailSender getStrategy(String email) {
        if (email.toLowerCase().endsWith("@gmail.com")) {
            return new GmailStrategy();
        } else if (email.toLowerCase().endsWith("@yahoo.com")) {
            return new YahooStrategy();
        } else if (email.toLowerCase().endsWith("@walla.co.il")) {
            return new WallaStrategy();
        }
        return null;
    }


}
