package com.rohit.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Entity
@Table(name = "product")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(
        name = "Product.findByProductName",
        query = "select p.name from Product p where p.name=:name")
public class Product {

    // this can be a combination of 2 fields
    @Id
    // JPA will make sure that the primary key value generation is handled  by the db - it relies on an auto-increment column in the database
    @GeneratedValue
    private Long productId;
    private String name;
    private String description;
    private String category;
}
