package com.emailserver.strategy;

import com.emailserver.model.VendorConfig;


public class YahooStrategy extends EmailStrategy {
    public YahooStrategy(VendorConfig config) {
        super(config);
    }
}