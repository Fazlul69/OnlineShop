package com.example.onlineshop.model;

public class ProductImageSliderModel {
    private  int sliderImage;
    private String productNameDetails;

    public ProductImageSliderModel(int sliderImage, String productNameDetails) {
        this.sliderImage = sliderImage;
        this.productNameDetails = productNameDetails;
    }

    public int getSliderImage() {
        return sliderImage;
    }

    public void setSliderImage(int sliderImage) {
        this.sliderImage = sliderImage;
    }

    public String getProductNameDetails() {
        return productNameDetails;
    }

    public void setProductNameDetails(String productNameDetails) {
        this.productNameDetails = productNameDetails;
    }
}
