package com.ascii274.retomwc2022.model;

public class Developer {
    private String name;
    private String email;
    private Categoria category;
    private String phone;
    private String date;

    public Developer(String name, String email, Categoria category, String phone, String date) {
        this.name = name;
        this.email = email;
        this.category = category;
        this.phone = phone;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", category=" + category +
                ", phone='" + phone + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}