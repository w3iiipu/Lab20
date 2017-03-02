package com.test.model;

import java.math.BigDecimal;

public class Inventory {
    private String ItemID;
    private String Name;
    private String Description;
    private int Quantity;
    private BigDecimal Price;

    public Inventory(String itemID, String name, String description, int quantity, BigDecimal price) {
        this.ItemID = itemID;
        this.Name = name;
        this.Description = description;
        this.Quantity = quantity;
        this.Price = price;
    }



    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        this.ItemID = itemID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        this.Price = price;
    }
}
