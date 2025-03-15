package org.labs.Tasks2.Task11;

interface StockObserver {
    void update(Stock stock, double oldPrice, double newPrice);
}