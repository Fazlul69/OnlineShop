package com.example.onlineshop.model;

public class FlashDealModel {

    private int flashDealProductImage;
    private String flashDealProductName;
    private String FlashDealProductPrice;

    public FlashDealModel(int flashDealProductImage, String flashDealProductName, String flashDealProductPrice) {
        this.flashDealProductImage = flashDealProductImage;
        this.flashDealProductName = flashDealProductName;
        FlashDealProductPrice = flashDealProductPrice;
    }

    public int getFlashDealProductImage() {
        return flashDealProductImage;
    }

    public void setFlashDealProductImage(int flashDealProductImage) {
        this.flashDealProductImage = flashDealProductImage;
    }

    public String getFlashDealProductName() {
        return flashDealProductName;
    }

    public void setFlashDealProductName(String flashDealProductName) {
        this.flashDealProductName = flashDealProductName;
    }

    public String getFlashDealProductPrice() {
        return FlashDealProductPrice;
    }

    public void setFlashDealProductPrice(String flashDealProductPrice) {
        FlashDealProductPrice = flashDealProductPrice;
    }
}
