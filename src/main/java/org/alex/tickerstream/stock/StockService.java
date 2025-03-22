package org.alex.tickerstream.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service// Marks a Java class as a component, making it managed by the Spring container; manage class lifecycle.
public class StockService {
    private final StockRepository stockRepository;

    @Autowired // Inject StockRepository bean into the service, allowing it to interact with the DB.
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    /**
     * Retrieves all stocks from the database.
     * @return a list of all Stock entities.
     */
    public List<Stock> getAllStocks(){
        return stockRepository.findAll();
    }

    /**
     * Finds a stock by its ticker symbol and date
     *
     * @param tickerSymbol the stock's ticker symbol
     * @param date the trading date
     * @return an Optional containing the found Stock or empty if not found
     *
     */
    public Optional<Stock> getStockByTickerAndDate(String tickerSymbol, String date){
        StockPK id = new StockPK(tickerSymbol, date);
        return stockRepository.findById(id);
    }

    /**
     * Finds all Stock entities with a given ticker symbol descending order
     *
     * @param tickerSymbol the stock's ticker symbol
     * @return a List of Stock entities with the given ticker symbol in descending order
     */
    public List<Stock> getStocksByTickerDescending(String tickerSymbol){
        return stockRepository.findByTickerSymbolOrderByDateDesc(tickerSymbol);
    }

    /**
     * Finds all Stock entities with a given ticker symbol ascending order
     *
     * @param tickerSymbol the stock's ticker symbol
     * @return a List of stock entities with the given ticker symbol in ascending order
     */
    public List<Stock> getStocksByTickerAscending(String tickerSymbol){
        return stockRepository.findByTickerSymbolOrderByDateAsc(tickerSymbol);
    }


    /**
     * Check if a Stock with a given ticker symbol and date exists
     *
     * @param tickerSymbol the stock's ticker symbol
     * @param date the trading date
     * @return true if the stock exists, false otherwise
     */
    public boolean stockExists(String tickerSymbol, String date){
        StockPK id = new StockPK(tickerSymbol, date);
        return stockRepository.existsById(id);
    }


}
