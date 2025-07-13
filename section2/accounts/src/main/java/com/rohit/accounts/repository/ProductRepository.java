package com.rohit.accounts.repository;

import com.rohit.accounts.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Named Query
    @Query(name = "Product.findByProductName")
    Product findByName(String name);

    // DerivedQuery
    Product findByProductId(Long productId);

    // ComplexQuery
    @Query(value = "select * from product where id=:name and category=:category", nativeQuery = true)
    Product findProd(String name,String category);

    // Paging
    // You get paging and sorting out of the box!
    Page<Product> findByCategory(String category, Pageable pageable);


    //ony soring
}
