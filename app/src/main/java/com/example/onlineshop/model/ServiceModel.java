package com.example.onlineshop.model;

public class ServiceModel {

    private String service_name;
    private int service_image;

    public ServiceModel(String service_name, int service_image) {
        this.service_name = service_name;
        this.service_image = service_image;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public int getService_image() {
        return service_image;
    }

    public void setService_image(int service_image) {
        this.service_image = service_image;
    }
}
