package org.alex.tickerstream.stock;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="stocks")
@IdClass(StockPK.class) // Using a separate class to represent the composite primary key (ticker_symbol, date)
public class Stock {
    @Id // Marks as part of the primary key
    @Column(name = "ticker_symbol")
    private String tickerSymbol;

    @Id // Other part of the primary key
    private String date;

    private float open;
    private float high;
    private float low;
    private float close;

    @Column(name = "adj_close")
    private float adjClose;

    private int volume;

    // Empty Constructor
    public Stock() {

    }

    // Parameterized Constructor
    public Stock(String tickerSymbol, String date, float open, float high, float low, float close, float adjClose, int volume) {
        this.tickerSymbol = tickerSymbol;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.adjClose = adjClose;
        this.volume = volume;
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

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getClose() {
        return close;
    }

    public void setClose(float close) {
        this.close = close;
    }

    public float getAdjClose() {
        return adjClose;
    }

    public void setAdjClose(float adjClose) {
        this.adjClose= adjClose;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}

