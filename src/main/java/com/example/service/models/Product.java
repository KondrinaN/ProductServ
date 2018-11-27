package com.example.service.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="Products")
@NamedQueries(
        {
            @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Product p")
        }
)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    @Column(name = "NameProduct")
    private String name;

    @Column(name="Count")
    private Long count;

    @Column(name = "Price")
    private BigDecimal price;

    public Product() {
    }

    public Product(String name, Long count, BigDecimal price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}

