package org.alex.tickerstream.stock;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="stocks")
@IdClass(StockPK.class) // Using a separate class to represent the composite primary key (ticker_symbol, date)
public class Stock {
    @Id // Marks as part of the primary key
    private String tickerSymbol;

    @Id // Other part of the primary key
    private String date;

    private float open;
    private float high;
    private float low;
    private float close;
    private float adj_close;
    private int volume;
}

class StockPK implements Serializable {
    private String tickerSymbol;
    private String date;

    // Empty constructor, required by JPA
    public StockPK() {

    }

    // Equals and hashCode (required)

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