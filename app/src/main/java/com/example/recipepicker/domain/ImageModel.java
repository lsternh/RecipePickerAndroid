package com.example.recipepicker.domain;

public class ImageModel {

    String name;
    String type;
    String imageBytes;

    public ImageModel() {
    }

    public ImageModel(String name, String type, String imageBytes) {
        this.name = name;
        this.type = type;
        this.imageBytes = imageBytes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(String imageBytes) {
        this.imageBytes = imageBytes;
    }

}
