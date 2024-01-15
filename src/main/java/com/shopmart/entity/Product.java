package com.shopmart.entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Product name is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Product name must contain only letters")
    private String name;
    @NotNull(message = "Product price is required")
    @DecimalMin(value = "0.0", message = "Product price must be greater than or equal to 0")
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull(message = "Category is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Category name must contain only letters")
    private Category category;

    public Product(Long id, String name, double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
