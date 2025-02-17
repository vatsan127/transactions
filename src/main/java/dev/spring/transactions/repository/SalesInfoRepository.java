package dev.spring.transactions.repository;

import dev.spring.transactions.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesInfoRepository extends JpaRepository<Sales, Integer> {

}
