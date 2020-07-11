package com.example.onlineshop.model;

public class TabModel {

    private int tab_item_image;
    private String tab_item_name;

    public TabModel(int tab_item_image, String tab_item_name) {
        this.tab_item_image = tab_item_image;
        this.tab_item_name = tab_item_name;
    }

    public int getTab_item_image() {
        return tab_item_image;
    }

    public void setTab_item_image(int tab_item_image) {
        this.tab_item_image = tab_item_image;
    }

    public String getTab_item_name() {
        return tab_item_name;
    }

    public void setTab_item_name(String tab_item_name) {
        this.tab_item_name = tab_item_name;
    }
}
