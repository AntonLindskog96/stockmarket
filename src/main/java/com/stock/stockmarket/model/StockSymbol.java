package com.stock.stockmarket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockSymbol {
    private String symbol;
    private String description;
    private String type;
    private String currency;

    public StockSymbol(String symbol, String description, String type) {
        this.symbol = symbol;
        this.description = description;
        this.currency = currency;
        this.type = type;
    }


    // Getters and Setters for each field
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    // Optionally, you can add a constructor with arguments if needed
    public StockSymbol(String symbol, String description, String type, String currency) {
        this.symbol = symbol;
        this.description = description;
        this.type = type;
        this.currency = currency;
    }
}