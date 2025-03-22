package org.alex.tickerstream.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Extends the JpaRepository interface which provides CRUD (Create, Read, Update, Delete) for the stock entity.
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, StockPK> {
    /*
    Note: Methods here should match Entity field names.
    Note: No implementation code necessary here. Spring JPA will effectively parse the method name and create a Query for it.
    This is called query method name resolution. You can also write custom queries with @Query
    It does this by:
    1. Proxy Generation - on start, Spring creates a proxy implementation of the repo interface
    2. Method Name Parsing - spring has a query builder that parses method names according to a predefined set of keywords and naming conventions
    3. Query Creation - Based on the parsed method name, a JPA query is generated which ultimately becomes an SQL query.
    Example: findByTickerSymbolOrderByDateDesc breaks down to:
        SELECT * FROM stocks
        WHERE ticker_symbol = ?
        ORDER BY date DESC
     */


    /**
     * Finds a stock by its ticker symbol
     * @param tickerSymbol the stock's ticker symbol
     * @return an Optional containing the found Stock or empty if not found
     */
    Optional<Stock> findByTickerSymbol(String tickerSymbol);

    /**
     * Find all Stock entities with a specific ticker symbol, ordered by date descending
     * @param tickerSymbol the stock's ticker symbol
     * @return a List of Stock entities with the given ticker symbol ordered by date descending
     */
    List<Stock> findByTickerSymbolOrderByDateDesc(String tickerSymbol);

    /**
     * Find all Stock entities with a specific ticker symbol, ordered by date ascending
     * @param tickerSymbol the stock's ticker symbol
     * @return a List of Stock entities with the given ticker symbol ordered by date ascending
     */
    List<Stock> findByTickerSymbolOrderByDateAsc(String tickerSymbol);

    /**
    * Finds a Stock by its ticker symbol and date.
    *
    * @param tickerSymbol the stock's ticker symbol
    * @param date the trading date
    * @return an Optional containing the found Stock or empty if not found
    */
    Optional<Stock> findByTickerSymbolAndDate(String tickerSymbol, String date);
}
