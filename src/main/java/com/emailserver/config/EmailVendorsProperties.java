package com.emailserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "email.vendors")
public class EmailVendorsProperties {

    private Vendor gmail = new Vendor();
    private Vendor walla = new Vendor();
    private Vendor yahoo = new Vendor();

    public static class Vendor {
        private String postfix;
        private String host;
        private String username;
        private String password;

        public String getPostfix() { return postfix; }
        public void setPostfix(String postfix) { this.postfix = postfix; }

        public String getHost() { return host; }
        public void setHost(String host) { this.host = host; }

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }

    public Vendor getGmail() { return gmail; }
    public void setGmail(Vendor gmail) { this.gmail = gmail; }

    public Vendor getWalla() { return walla; }
    public void setWalla(Vendor walla) { this.walla = walla; }

    public Vendor getYahoo() { return yahoo; }
    public void setYahoo(Vendor yahoo) { this.yahoo = yahoo; }
}
