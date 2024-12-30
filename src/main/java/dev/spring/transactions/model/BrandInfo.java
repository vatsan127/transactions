package dev.spring.transactions.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "brand_info")
public class BrandInfo {

    @Id
    @GeneratedValue
    private int id;
    private String brandName;
}
