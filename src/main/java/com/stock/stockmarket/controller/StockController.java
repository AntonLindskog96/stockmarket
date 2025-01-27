package com.stock.stockmarket.controller;

import com.stock.stockmarket.model.StockQuote;
import com.stock.stockmarket.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    private final StockService stockService;

    // En REST-kontroller som hanterar förfrågningar för att få priset på en aktie baserat på dess symbol.
    @GetMapping("/{symbol}/price")
    public ResponseEntity<Double> getStockPrice(@PathVariable String symbol) {
        try {
            double price = stockService.getStockPrice(symbol);
            return ResponseEntity.ok(price);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{symbol}/details")
    public ResponseEntity<StockQuote> getStockDetails(@PathVariable String symbol) {
        try {
            StockQuote stockQuote = stockService.getStockDetails(symbol);
            return ResponseEntity.ok(stockQuote);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}

