package com.emailserver.strategy;

import com.emailserver.config.VendorConfiguration;
import com.emailserver.model.EmailRequest;
import com.emailserver.model.VendorConfig;


public class YahooStrategy extends EmailSender {
    public YahooStrategy() {
        super(VendorConfiguration.getConfig("yahoo.com"));
    }
}