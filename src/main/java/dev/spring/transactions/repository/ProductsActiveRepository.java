package dev.spring.transactions.repository;

import dev.spring.transactions.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsActiveRepository extends JpaRepository<Product, Integer> {
}
