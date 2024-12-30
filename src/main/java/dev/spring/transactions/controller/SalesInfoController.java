package dev.spring.transactions.controller;

import dev.spring.transactions.model.SalesInfo;
import dev.spring.transactions.service.SalesInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalesInfoController {

    private final SalesInfoService salesInfoService;

    public SalesInfoController(SalesInfoService salesInfoService) {
        this.salesInfoService = salesInfoService;
    }

    @GetMapping
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

}
