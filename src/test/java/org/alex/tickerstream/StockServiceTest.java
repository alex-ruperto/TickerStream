package org.alex.tickerstream;

import org.alex.tickerstream.stock.Stock;
import org.alex.tickerstream.stock.StockPK;
import org.alex.tickerstream.stock.StockRepository;
import org.alex.tickerstream.stock.StockService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Can also use SpringBootTest, but it is also slower since it will bring in the entire environment.
public class StockServiceTest {
    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockService stockService;

    /*
    Example:
    ticker_symbol | date | open | high | low | close | adj_close | volume
    AMC | 2013-12-18 | 19.18 | 19.79 | 18.90 | 18.90 | 13.59 | 5457200
     */
    @Test
    public void testGetSpecificAMCStock(){
        // Arrange
        String tickerSymbol = "AMC";
        String date = "2013-12-18";

        // Create the stock with the exact values from your example
        Stock amcStock = new Stock(
                tickerSymbol,
                date,
                19.18f,  // open
                19.79f,  // high
                18.90f,  // low
                18.90f,  // close
                13.59f,  // adjClose
                5457200  // volume
        );

        // Create the composite key
        StockPK stockId = new StockPK(tickerSymbol, date);

        // Mock the repository to return our stock when findById is called with this key
        when(stockRepository.findById(stockId)).thenReturn(Optional.of(amcStock));

        // Act
        Optional<Stock> result = stockService.getStockByTickerAndDate(tickerSymbol, date);

        // Assert
        assertTrue(result.isPresent());
        Stock foundStock = result.get();

        // Verify all fields matched correctly
        assertEquals(tickerSymbol, foundStock.getTickerSymbol(), "Ticker symbol should match");
        assertEquals(date, foundStock.getDate(), "Date should match");
        assertEquals(19.18f, foundStock.getOpen(), "Open price should match");
        assertEquals(19.79f, foundStock.getHigh(), "High price should match");
        assertEquals(18.90f, foundStock.getLow(), "Low price should match");
        assertEquals(18.90f, foundStock.getClose(), "Close price should match");
        assertEquals(13.59f, foundStock.getAdjClose(), "Adjusted close price should match");
        assertEquals(5457200, foundStock.getVolume(), "Volume should match");

        // Verify that the repository method was called exactly once with the correct ID
        verify(stockRepository, times(1)).findById(stockId);
    }
}
