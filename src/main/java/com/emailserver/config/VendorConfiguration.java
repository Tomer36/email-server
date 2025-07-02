package com.emailserver.config;

import com.emailserver.model.VendorConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class VendorConfiguration {

    private static final Map<String, VendorConfig> vendorConfigMap = new HashMap<>();

    @PostConstruct
    public void init() {
        vendorConfigMap.put("gmail.com", new VendorConfig("smtp.gmail.com", "admin", "admin"));
        vendorConfigMap.put("walla.co.il", new VendorConfig("smtp.walla.co.il", "admin", "admin"));
        vendorConfigMap.put("yahoo.com", new VendorConfig("smtp.yahoo.com", "admin", "admin"));
    }

    public static VendorConfig getConfig(String domain) {
        return vendorConfigMap.get(domain);
    }
}
