package dev.spring.transactions.repository;

import dev.spring.transactions.model.BrandInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandInfoRepository extends JpaRepository<BrandInfo, Integer> {
}
