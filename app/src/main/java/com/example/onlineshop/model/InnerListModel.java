package com.example.onlineshop.model;

public class InnerListModel {
    private int innerCategoryImage;
    private String innerCategoryname;

    public InnerListModel(int innerCategoryImage, String innerCategoryname) {
        this.innerCategoryImage = innerCategoryImage;
        this.innerCategoryname = innerCategoryname;
    }

    public int getInnerCategoryImage() {
        return innerCategoryImage;
    }

    public void setInnerCategoryImage(int innerCategoryImage) {
        this.innerCategoryImage = innerCategoryImage;
    }

    public String getInnerCategoryname() {
        return innerCategoryname;
    }

    public void setInnerCategoryname(String innerCategoryname) {
        this.innerCategoryname = innerCategoryname;
    }
}
