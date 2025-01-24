package com.example.productcatalog.Repository;

import com.example.productcatalog.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findById(Long id);

    Product save(Product product);

    void deleteById(Long id);

    List<Product> findAll();


    @Query(value = "SELECT * FROM product p " +
            "WHERE (LOWER(p.name) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(p.description) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "AND (p.price >= :minpricefilter AND p.price <= :maxpricefilter)",
            nativeQuery = true)
    List<Product> searchProducts(@Param("search") String search, @Param("minpricefilter") Integer minpricefilter, @Param("maxpricefilter") Integer maxpricefilter);


}
