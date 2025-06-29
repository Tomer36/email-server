package com.emailserver.factory;

import com.emailserver.strategy.EmailStrategy;
import com.emailserver.strategy.GmailStrategy;
import com.emailserver.strategy.WallaStrategy;
import com.emailserver.strategy.YahooStrategy;

public class EmailStrategyFactory {

    public static EmailStrategy getStrategy(String email) {
        if (email.toLowerCase().endsWith("@gmail.com")) {
            return new GmailStrategy();
        }
        if (email.toLowerCase().endsWith("@yahoo.com")) {
            return new YahooStrategy();
        }
        if (email.toLowerCase().endsWith("@walla.com")) {
            return new WallaStrategy();
        } else return null;
    }


}
