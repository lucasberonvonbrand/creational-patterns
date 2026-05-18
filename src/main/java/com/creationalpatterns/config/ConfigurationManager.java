package com.creationalpatterns.config;

public class ConfigurationManager {

    private static ConfigurationManager instance;
    private double maxDiscountLimit;
    private String baseCurrency;

    // Constructor privado para evitar que el cliente use "new"
    private ConfigurationManager() {
        this.maxDiscountLimit = 0.50; // 50% máximo
        this.baseCurrency = "ARS"; //Pesos argentinos
    }

    public static synchronized ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public double getMaxDiscountLimit() { return maxDiscountLimit; }
    public String getBaseCurrency() { return baseCurrency; }
}
