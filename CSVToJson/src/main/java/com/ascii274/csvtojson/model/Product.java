package com.ascii274.csvtojson.model;

import com.opencsv.bean.CsvBindByName;


public class Product {

    @CsvBindByName
    private int code;
    @CsvBindByName
    private String product;
    @CsvBindByName
    private Double price;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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
                ", product='" + product + '\'' +
                ", price=" + price +
                '}';
    }
}
