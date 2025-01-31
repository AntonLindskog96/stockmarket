package com.stock.stockmarket.model;

import java.util.ArrayList;
import java.util.List;

public class MyPortfolio {
    private List<StockInPortfolio> stocks;
    public MyPortfolio() {
        this.stocks = new ArrayList<>();
    }

    public void addStock(StockInPortfolio stock) {
        this.stocks.add(stock);
    }

    public void removeStock(String symbol) {
        this.stocks.removeIf(stock -> stock.getSymbol().equals(symbol));
    }

    public List<StockInPortfolio> getStocks() {
        return stocks;
    }

    // Hämta det totala värdet för portföljen
    public double getTotalPortfolioValue(List<StockQuote> stockQuotes) {
        double totalValue = 0;

        for (StockInPortfolio stock : stocks) {
            for (StockQuote quote : stockQuotes) {
                if (quote.getStockSymbol().getSymbol().equals(stock.getSymbol())) {
                    totalValue += stock.getQuantity() * quote.getC(); // Använder senaste priset
                }
            }
        }
        return totalValue;
    }
}
