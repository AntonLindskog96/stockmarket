package com.stock.stockmarket.controller;

import com.stock.stockmarket.model.StockQuote;
import com.stock.stockmarket.service.StockService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class StockControllerTest {

    @InjectMocks
    private StockController stockController;

    @Mock
    private StockService stockService;

    @Test // Testar om details fungerar
    public void testGetStockDetails() throws Exception {
        StockQuote mockStockQuote = new StockQuote();
        mockStockQuote.setC(365.89);
        mockStockQuote.setH(370.00);

        when(stockService.getStockDetails("NFLX")).thenReturn(mockStockQuote);

        // Testa controller-metoden.
        ResponseEntity<StockQuote> response = stockController.getStockDetails("NFLX");

        // Verifiera att vi får rätt status och data.
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(365.89, response.getBody().getC());
        assertEquals(370.00, response.getBody().getH());
    }
}