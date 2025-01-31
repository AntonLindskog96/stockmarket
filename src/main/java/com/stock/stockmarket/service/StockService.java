package com.stock.stockmarket.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stock.stockmarket.model.StockQuote;
import com.stock.stockmarket.model.StockSymbol;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class StockService {
    private static final String API_KEY = "cu94v51r01qnf5nm5nb0cu94v51r01qnf5nm5nbg";
    private static final String BASE_URL = "https://finnhub.io/api/v1/";

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public StockService() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    private String makeApiRequest(String url) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to fetch data: " + response.body());
        }

        return response.body();
    }

    public double getStockPrice(String symbol) throws Exception {
        String url = BASE_URL + "quote?symbol=" + symbol + "&token=" + API_KEY;
        String response = makeApiRequest(url);
        StockQuote stockQuote = objectMapper.readValue(response, StockQuote.class);
        return stockQuote.getC();
    }


    public StockQuote getStockDetails(String symbol) throws Exception {
        String url = BASE_URL + "quote?symbol=" + symbol + "&token=" + API_KEY;
        String response = makeApiRequest(url);
        return objectMapper.readValue(response, StockQuote.class);
    }

    public List<StockQuote> getTopStocks() throws Exception {
        List<String> symbols = Arrays.asList("AMZN", "AAPL", "NFLX", "TSLA", "GOOGL", "MSFT", "META", "NVDA", "AMD", "GME");

        List<StockQuote> topStocks = new ArrayList<>();
        for (String symbol : symbols) {
            StockQuote stockQuote = getStockDetails(symbol);
            StockSymbol stockSymbol = new StockSymbol(symbol, symbol, "USD", "Equity");
            stockQuote.setStockSymbol(stockSymbol);
            topStocks.add(stockQuote);
        }

        return topStocks;
    }
}
