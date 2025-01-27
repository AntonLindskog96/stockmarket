package com.stock.stockmarket.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stock.stockmarket.model.StockQuote;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@AllArgsConstructor
public class StockService
{
private static final String API_KEY = "cu94v51r01qnf5nm5nb0cu94v51r01qnf5nm5nbg";
private static final String BASE_URL = "https://finnhub.io/api/v1/";

private final HttpClient httpClient;
private final ObjectMapper objectMapper;

    public StockService() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public double getStockPrice(String symbol) throws Exception {
        String url = BASE_URL + "quote?symbol=" + symbol + "&token=" + API_KEY;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to fetch data " + response.body());
        }
        StockQuote stockQuote = objectMapper.readValue(response.body(), StockQuote.class);
        return stockQuote.getC();
    }
    public StockQuote getStockDetails(String symbol) throws Exception {
        String url = BASE_URL + "quote?symbol=" + symbol + "&token=" + API_KEY;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to fetch stock details: " + response.body());
        }
        return objectMapper.readValue(response.body(), StockQuote.class);
    }
}
