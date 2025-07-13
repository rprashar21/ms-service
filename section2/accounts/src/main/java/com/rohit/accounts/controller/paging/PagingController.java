package com.rohit.accounts.controller.paging;

import java.util.List;

import com.rohit.accounts.entity.Product;
import com.rohit.accounts.repository.ProductRepository;
import com.rohit.accounts.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/api")
@RestController
@Validated
@RequiredArgsConstructor
public class PagingController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    // wirte a method for pagination
    @GetMapping("/pagination")
    public ResponseEntity<Page<Product>> getProduct(@RequestParam String category) {

        Page<Product> products = productService.findProductByCategoryAndSortByName(category);
        return ResponseEntity.ok().body(products);
    }

    // with page size and categor

    @GetMapping("/pagination/limit")
    public ResponseEntity<Page<Product>> getProducts(
            @RequestParam String category,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy) {

        Page<Product> products = productService.
                findProductByUserInputs(page, size, sortBy, category);

        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/pagination/all")
    public ResponseEntity<List<Product>> getProduct() {
        return ResponseEntity.ok().body(productRepository.findAll());

    }

    @GetMapping("/pagination/all/page")
    public ResponseEntity<Page<Product>> getProducts() {

        // this is a quick example where this will only show 2 pages per request
        Pageable pageable = PageRequest.of(0, 2);
        return ResponseEntity.ok().body(productRepository.findAll(pageable));

    }

    // sample output
    //{
    //    "content": [
    //        {
    //            "productId": 1,
    //            "name": "product-1",
    //            "description": "desc --xx -- 1 ",
    //            "category": "PROD1 -- "
    //        },
    //        {
    //            "productId": 2,
    //            "name": "product-2",
    //            "description": "desc --xx -- 2 ",
    //            "category": "PROD4 -- "
    //        }
    //    ],
    //    "pageable": {
    //        "pageNumber": 0,
    //        "pageSize": 2,
    //        "sort": {
    //            "empty": true,
    //            "unsorted": true,
    //            "sorted": false
    //        },
    //        "offset": 0,
    //        "unpaged": false,
    //        "paged": true
    //    },
    //    "totalPages": 600,
    //    "totalElements": 1200,
    //    "last": false,
    //    "size": 2,
    //    "number": 0,
    //    "sort": {
    //        "empty": true,
    //        "unsorted": true,
    //        "sorted": false
    //    },
    //    "numberOfElements": 2,
    //    "first": true,
    //    "empty": false
    //}
}
