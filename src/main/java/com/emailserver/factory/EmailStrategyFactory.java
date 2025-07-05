package com.emailserver.factory;

import com.emailserver.config.VendorConfiguration;
import com.emailserver.model.VendorConfig;
import com.emailserver.strategy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailStrategyFactory {

    private final VendorConfiguration vendorConfiguration;

    @Autowired
    public EmailStrategyFactory(VendorConfiguration vendorConfiguration) {
        this.vendorConfiguration = vendorConfiguration;
    }

    public EmailStrategy getStrategy(String email) {
        VendorConfig config = vendorConfiguration.getConfigByEmail(email);

        // Use class name to route to correct strategy, or you could keep a mapping if needed
        String postfix = email.substring(email.indexOf('@')).toLowerCase();
        if (postfix.equals("@gmail.com")) {
            return new GmailStrategy(config);
        } else if (postfix.equals("@walla.co.il")) {
            return new WallaStrategy(config);
        } else if (postfix.equals("@yahoo.com")) {
            return new YahooStrategy(config);
        }
        throw new IllegalArgumentException("Unsupported email postfix: " + postfix);
    }
}
