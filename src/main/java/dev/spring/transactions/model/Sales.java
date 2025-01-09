package dev.spring.transactions.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "sold_units", nullable = false)
    private int soldUnits;
}
