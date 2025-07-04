package com.emailserver.strategy;

import com.emailserver.config.VendorConfiguration;


public class YahooStrategy extends EmailStrategy {
    public YahooStrategy() {
        super(VendorConfiguration.getConfig("yahoo.com"));
    }
}