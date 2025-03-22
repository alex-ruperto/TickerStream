package org.alex.tickerstream.stock;

import java.io.Serializable;

public class StockPK implements Serializable {
    private String tickerSymbol;
    private String date;

    // Empty constructor, required by JPA
    public StockPK() {

    }

    // Constructor with parameters
    public StockPK(String tickerSymbol, String date) {
        this.tickerSymbol = tickerSymbol;
        this.date = date;
    }

    // Getters and Setters
    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Equals Method - required for composite keys
     * Two StockPK objects are equal if they have the same tickerSymbol and date
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Same object reference
        if (o == null || getClass() != o.getClass()) return false; // Null or different class check
        StockPK pk = (StockPK) o;
        // Compare both fields that make up the primary key
        return tickerSymbol.equals(pk.tickerSymbol) && date.equals(pk.date);
    }

    /**
     * Hashcode Method - required for composite keys
     * Used when StockPK objects are used in hash-based collections
     */
    @Override
    public int hashCode() {
        return tickerSymbol.hashCode() + date.hashCode();
    }

}
