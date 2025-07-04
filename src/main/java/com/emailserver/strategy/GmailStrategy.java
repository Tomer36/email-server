package com.emailserver.strategy;

import com.emailserver.config.VendorConfiguration;

public class GmailStrategy extends EmailSender {
    public GmailStrategy() {
        super(VendorConfiguration.getConfig("gmail.com"));
    }
}

