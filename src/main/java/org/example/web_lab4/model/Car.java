package org.example.web_lab4.model;

import java.math.BigDecimal;

public class Car {
    private final int id;
    private final String name;
    private final String brand;
    private final BigDecimal price;

    public Car(int id, String name, String brand, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public BigDecimal getPrice() { return price; }
}

