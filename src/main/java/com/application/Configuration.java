package com.application;

public class Configuration {
    public static String getSecret() {
        return System.getenv("lt_api_key");
    }
}
