package dev.spring.transactions.controller;

import dev.spring.transactions.model.Brand;
import dev.spring.transactions.repository.BrandInfoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand-info")
public class BrandInfoController {

    private final BrandInfoRepository brandInfoRepository;

    public BrandInfoController(BrandInfoRepository brandInfoRepository) {
        this.brandInfoRepository = brandInfoRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Brand>> getAllBrandInfo() {
        return ResponseEntity.ok(brandInfoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandInfoById(@PathVariable int id) {
        return brandInfoRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}
