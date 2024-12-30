package dev.spring.transactions.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "brand_info")
public class BrandInfo {

    @Id
    private int id;

    @Column(name = "name", length = 50, nullable = false)
    private String brandName;
}
