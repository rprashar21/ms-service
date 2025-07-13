package com.rohit.accounts.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import com.rohit.accounts.entity.Product;
import com.rohit.accounts.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;


    public Page<Product> findProductByCategoryAndSortByName(String category) {

        // we can take these pageNumber pageSize as query paramms from endpoint
        Pageable pageable = PageRequest.of(0, 10, Sort.by("name").descending());
        return productRepository.findByCategory(category, pageable);


    }

    public Page<Product> findProductByUserInputs(int pageNumber, int pageSize
            , String sortByField, String category) {

        // we can take these pageNumber pageSize as query paramms from endpoint
        Pageable pageable = PageRequest.of(pageNumber, pageSize,
                Sort.by(sortByField).descending());
        return productRepository.findByCategory(category, pageable);


    }

    @PostConstruct
    public void init() {
        try {
            log.info("Initializing products");
            List<Product> productList = LongStream.rangeClosed(1, 200)
                    .mapToObj(i -> new Product(null, "product-" + i,
                            "desc --xx -- " + i + " ", "PROD" + i * i + " -- ")).collect(Collectors.toList());

            productRepository.saveAll(productList);
            log.info("Products saved successfully");
        } catch (Exception e) {
            log.error("Error initializing products: {}", e.getMessage(), e);
            throw e;
        }
    }
}
