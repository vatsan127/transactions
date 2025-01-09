package dev.spring.transactions.controller;

import dev.spring.transactions.model.Sales;
import dev.spring.transactions.service.SalesInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales-info")
public class SalesInfoController {

    private final SalesInfoService salesInfoService;

    public SalesInfoController(SalesInfoService salesInfoService) {
        this.salesInfoService = salesInfoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Sales>> getAllSalesInfo() {
        List<Sales> salesList = salesInfoService.getAllSalesInfo();
        return ResponseEntity.ok(salesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sales> getSalesInfoById(@PathVariable int id) {
        salesInfoService.getSalesInfoById(id);
        return salesInfoService.getSalesInfoById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Sales> createSalesInfo(@RequestBody Sales sales) {
        Sales savedSales = salesInfoService.createSalesInfo(sales);
        return ResponseEntity.ok(savedSales);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Sales> createSalesInfo(@PathVariable int id) {
        Optional<Sales> salesInfo = salesInfoService.getSalesInfoById(id);
        if (salesInfo.isPresent()) {
            salesInfoService.deleteSaleInfo(id);
            return ResponseEntity.ok(salesInfo.get());
        } else return ResponseEntity.notFound().build();
    }

}
