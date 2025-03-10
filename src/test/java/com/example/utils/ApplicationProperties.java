package com.example.utils;

import java.io.IOException;
import java.util.Properties;

public enum ApplicationProperties {
    INSTANCE;
    private final Properties properties;

    ApplicationProperties() {
        properties = new Properties();

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public String getUsername() { return properties.getProperty("username");}
    public String getPassword(){ return properties.getProperty("password");}

    public String setHeadless() { return properties.getProperty("setHeadless");}
}

