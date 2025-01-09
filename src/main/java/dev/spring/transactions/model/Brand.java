package dev.spring.transactions.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "brand")
public class Brand {

    @Id
    private int id;

    @Column(name = "name", length = 50, nullable = false)
    private String brandName;
}
