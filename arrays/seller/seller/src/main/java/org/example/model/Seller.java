package org.example.model;

public class Seller {

    private String name;
    private Double amount;

    public Seller() {}

    public Seller(String name, Double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
