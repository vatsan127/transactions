package dev.spring.transactions.controller;

import dev.spring.transactions.model.SalesInfo;
import dev.spring.transactions.service.SalesInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SalesInfoController {

    private final SalesInfoService salesInfoService;

    public SalesInfoController(SalesInfoService salesInfoService) {
        this.salesInfoService = salesInfoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<SalesInfo>> getAllSalesInfo() {
        List<SalesInfo> salesInfoList = salesInfoService.getAllSalesInfo();
        return ResponseEntity.ok(salesInfoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesInfo> getSalesInfoById(@PathVariable int id) {
        return salesInfoService.getSalesInfoById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<SalesInfo> createSalesInfo(@RequestBody SalesInfo salesInfo) {
        SalesInfo savedSalesInfo = salesInfoService.createSalesInfo(salesInfo);
        return ResponseEntity.ok(savedSalesInfo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SalesInfo> createSalesInfo(@PathVariable int id) {
        Optional<SalesInfo> salesInfo = salesInfoService.getSalesInfoById(id);
        if (salesInfo.isPresent()) {
            salesInfoService.deleteSaleInfo(id);
            return ResponseEntity.ok(salesInfo.get());
        } else return ResponseEntity.notFound().build();
    }

}
