package com.practice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    @Id
    Integer productId;

    @Column(nullable = false)
    String productName;

    @Column(nullable = false)
    Double productPrice;

    @Column(nullable = false)
    Integer productQuantity;


//    public Product(Integer productId, String productName, Double productPrice, Integer productQuantity) {
//        this.productId = productId;
//        this.productName = productName;
//        this.productPrice = productPrice;
//        this.productQuantity = productQuantity;
//    }
//
//    public Product() {
//
//    }
//
//    @Override
//    public String toString() {
//        return "Product{" +
//                "productId=" + productId +
//                ", productName='" + productName + '\'' +
//                ", productPrice=" + productPrice +
//                ", productQuantity=" + productQuantity +
//                '}';
//    }
}
