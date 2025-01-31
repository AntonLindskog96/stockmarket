package com.stock.stockmarket.model;

public class StockInPortfolio {
    private String symbol;
    private double quantity;
    private double price;

    public StockInPortfolio(String symbol, double quantity) {
        this.symbol = symbol;
        this.quantity = quantity;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getTotalPrice() {
        return quantity * price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
