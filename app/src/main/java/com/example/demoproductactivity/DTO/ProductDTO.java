package com.example.demoproductactivity.DTO;

public class ProductDTO {
    int id;
    String name;
    int price;
    int id_cat;

    public ProductDTO() {
    }

    public ProductDTO(String name, int price, int id_cat) {
        this.name = name;
        this.price = price;
        this.id_cat = id_cat;
    }

    public ProductDTO(int id, String name, int price, int id_cat) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.id_cat = id_cat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }
}

