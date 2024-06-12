package com.example.firebase_example;

public class CustomItems {
    private String url; // Alanı private olarak tanımlayın

    public CustomItems(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
