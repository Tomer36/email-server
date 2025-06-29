package com.emailserver.model;

public class VendorConfig {
    private String smtpServer;
    private String username;
    private String password;

    public VendorConfig(String smtpServer, String username, String password) {
        this.smtpServer = smtpServer;
        this.username = username;
        this.password = password;
    }

    public String getSmtpServer() {
        return smtpServer;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
