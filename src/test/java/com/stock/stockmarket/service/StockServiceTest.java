package com.stock.stockmarket.service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StockServiceTest
{
    @Autowired
    private StockService stockService;

    @Test
    void testGetStockPrice() throws Exception {
        double price = stockService.getStockPrice("AAPL");

        assertEquals(price > 0, true, "Price is above 0");
    }

}