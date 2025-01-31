package com.stock.stockmarket;

import com.stock.stockmarket.model.StockQuote;
import com.stock.stockmarket.model.StockSymbol;
import com.stock.stockmarket.service.StockService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class StockmarketApplication {
	public static void main(String[] args) {
		SpringApplication.run(StockmarketApplication.class, args);
		System.out.println("Market opening...");
		Scanner scanner = new Scanner(System.in);
		StockService stockService = new StockService();
		while (true) {
			System.out.println("välj ett alternativ");
			System.out.println("1. Se dina aktier");
			System.out.println("2. under process");
			System.out.println("3. under process");
			System.out.println("4. Avsluta");

			int value = scanner.nextInt();

			switch (value) {
				case 1:
					try {
						// get 10 stocks with current prices
						List<StockQuote> topStocks = stockService.getTopStocks();

						if (topStocks.isEmpty()) {
							System.out.println("No stocks found.");
						} else {
							System.out.println("Top 10 Stocks:");
							for (StockQuote stock : topStocks) {
								if (stock.getStockSymbol() != null) {
									String stockName = stock.getStockSymbol().getDescription();
									System.out.println("Stock: " + stockName + " | " + stock.getC());
								} else {
									System.out.println("Stock details are missing for this symbol.");
								}
							}
						}
					} catch (Exception e) {
						System.out.println("Error fetching top stocks: " + e.getMessage());
					}
					break;

				default:
					System.out.println("Ogiltigt val. Försök igen.");
			}


			System.out.println();
		}
	}
}