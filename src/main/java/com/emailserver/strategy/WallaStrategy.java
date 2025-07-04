package com.emailserver.strategy;
import com.emailserver.config.VendorConfiguration;


public class WallaStrategy extends EmailStrategy {
    public WallaStrategy() {
        super(VendorConfiguration.getConfig("walla.co.il"));
    }
}
