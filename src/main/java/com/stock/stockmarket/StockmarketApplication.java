package com.stock.stockmarket;

import com.stock.stockmarket.model.MyPortfolio;
import com.stock.stockmarket.model.StockQuote;
import com.stock.stockmarket.model.StockSymbol;
import com.stock.stockmarket.service.StockService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.stock.stockmarket.model.StockInPortfolio;


import java.util.List;
import java.util.Scanner;

@EnableAutoConfiguration
@SpringBootApplication

public class StockmarketApplication {
	public static void main(String[] args) {
		SpringApplication.run(StockmarketApplication.class, args);
		System.out.println("Market opening...");
		Scanner scanner = new Scanner(System.in);
		StockService stockService = new StockService();
		MyPortfolio portfolio = new MyPortfolio();

		//add applestock to portfolio to test
		portfolio.addStock(new StockInPortfolio("AAPL", 10)); // Lägg till 10 Apple-aktier till priset 150

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
						System.out.println("Error fetching stocks: " + e.getMessage());
					}
					break;
				case 2:
					try {
						// Beräkna portföljens totala värde
						double totalValue = portfolio.getTotalPortfolioValue(stockService.getTopStocks());
						System.out.println("Total Portfolio Value: " + totalValue);
					} catch (Exception e) {
						System.out.println("Error calculating total portfolio value: " + e.getMessage());
					}
					break;


				default:
					System.out.println("Try again, wrong input.");
			}


			System.out.println();
		}
	}
}