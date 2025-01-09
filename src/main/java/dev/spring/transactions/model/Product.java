package dev.spring.transactions.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "brand_id", nullable = false)
    private int brandId;

    @Column(name = "model", length = 100, nullable = false)
    private String model;

    @Column(name = "os", length = 100, nullable = false)
    private String os;
}
