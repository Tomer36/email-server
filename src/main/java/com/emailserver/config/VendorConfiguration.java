package com.emailserver.config;

import com.emailserver.model.VendorConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class VendorConfiguration {

    private final Map<String, VendorConfig> postfixToConfig = new HashMap<>();

    @Autowired
    public VendorConfiguration(EmailVendorsProperties vendorsProperties) {
        // Map postfix -> config for easy lookup
        putVendor(vendorsProperties.getGmail());
        putVendor(vendorsProperties.getWalla());
        putVendor(vendorsProperties.getYahoo());
    }

    private void putVendor(EmailVendorsProperties.Vendor vendor) {
        postfixToConfig.put(
                vendor.getPostfix().toLowerCase(),
                new VendorConfig(vendor.getHost(), vendor.getUsername(), vendor.getPassword())
        );
    }

    public VendorConfig getConfigByEmail(String email) {
        String postfix = extractPostfix(email);
        VendorConfig config = postfixToConfig.get(postfix.toLowerCase());
        if (config == null) {
            throw new IllegalArgumentException("Unsupported email postfix: " + postfix);
        }
        return config;
    }

    private String extractPostfix(String email) {
        return email.substring(email.indexOf('@'));
    }
}
