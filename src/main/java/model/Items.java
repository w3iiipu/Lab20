package model;

import java.math.BigDecimal;

public class Items {

    private String ItemID;
    private String Name;
    private String Description;
    private int Quantity;
    private BigDecimal Price;

    public Items(String itemID, String name, String description, int quantity, BigDecimal price) {
        ItemID = itemID;
        Name = name;
        Description = description;
        Quantity = quantity;
        Price = price;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }
}
