package com.emailserver.strategy;
import com.emailserver.config.VendorConfiguration;
import com.emailserver.model.VendorConfig;


public class WallaStrategy extends EmailSender {
    public WallaStrategy() {
        super(VendorConfiguration.getConfig("walla.co.il"));
    }
}
