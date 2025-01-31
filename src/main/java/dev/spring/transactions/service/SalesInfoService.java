package dev.spring.transactions.service;

import dev.spring.transactions.model.Sales;
import dev.spring.transactions.repository.SalesInfoRepository;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Cacheable("sales")
public class SalesInfoService {

    private final SalesInfoRepository salesInfoRepository;

    public SalesInfoService(SalesInfoRepository salesInfoRepository) {
        this.salesInfoRepository = salesInfoRepository;
    }

    public List<Sales> getAllSalesInfo() {
        return salesInfoRepository.findAll();
    }

    public Optional<Sales> getSalesInfoById(int id) {
        return salesInfoRepository.findById(id);
    }

    @CachePut("sales")
    public Sales createSalesInfo(Sales sales) {
        return salesInfoRepository.save(sales);
    }

    public void deleteSaleInfo(int id) {
        salesInfoRepository.deleteById(id);
    }
}
