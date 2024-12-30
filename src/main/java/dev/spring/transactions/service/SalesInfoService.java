package dev.spring.transactions.service;

import dev.spring.transactions.model.SalesInfo;
import dev.spring.transactions.repository.SalesInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesInfoService {

    private final SalesInfoRepository salesInfoRepository;

    public SalesInfoService(SalesInfoRepository salesInfoRepository) {
        this.salesInfoRepository = salesInfoRepository;
    }

    public List<SalesInfo> getAllSalesInfo() {
        return salesInfoRepository.findAll();
    }

    public Optional<SalesInfo> getSalesInfoById(int id) {
        return salesInfoRepository.findById(id);
    }

    public SalesInfo createSalesInfo(SalesInfo salesInfo) {
        return salesInfoRepository.save(salesInfo);
    }

    public void deleteSaleInfo(int id) {
        salesInfoRepository.deleteById(id);
    }
}
