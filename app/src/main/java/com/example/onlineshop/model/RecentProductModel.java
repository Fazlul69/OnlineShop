package com.example.onlineshop.model;

public class RecentProductModel {

    private int productItem;
    private String productName;
    private String productPrice;


    public RecentProductModel(int productItem, String productName, String productPrice) {
        this.productItem = productItem;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getProductItem() {
        return productItem;
    }

    public void setProductItem(int productItem) {
        this.productItem = productItem;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
