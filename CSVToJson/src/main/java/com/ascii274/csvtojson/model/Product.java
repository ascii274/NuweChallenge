package com.ascii274.csvtojson.model;

public class Product {

    private int code;

    private String productName;

    private Double price;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String product) {
        this.productName = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", product='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
