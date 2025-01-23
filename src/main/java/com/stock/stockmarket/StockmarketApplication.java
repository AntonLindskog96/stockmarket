package com.stock.stockmarket;

import com.stock.stockmarket.service.StockService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockmarketApplication {

	public static void main(String[] args) {
		StockService stockService = new StockService();
		try {
			double applePrice = stockService.getStockPrice("AAPL");
			System.out.println("APPLE " + applePrice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
