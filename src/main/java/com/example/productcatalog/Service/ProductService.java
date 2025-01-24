package com.example.productcatalog.Service;

import com.example.productcatalog.Repository.ProductRepository;
import com.example.productcatalog.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getSingleProduct(Long id){
        Product product = productRepository.findById(id);
        return product;
    }


    public List<Product> getSearchedProducts(String search, Integer minpricefilter, Integer maxpricefilter){
        if(search == null){
            search = "";
        }
        if(minpricefilter == null){
            minpricefilter = 0;
        }
        if(maxpricefilter == null){
            maxpricefilter = 0;
        }
        List<Product> products = productRepository.searchProducts(search, minpricefilter, maxpricefilter);
        return products;
    }


    public List<Product> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product createProduct(Long id, String name, String description, Double price) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        return productRepository.save(product);
    }

    public List<Product> createAllProducts(List<Product> products){
        List<Product> allProducts = new ArrayList<>();
        for(Product product : products){
            allProducts.add(createProduct(product.getId(), product.getName(), product.getDescription(), product.getPrice()));
        }
        return allProducts;
    }

    @Transactional
    public void deleteId(Long id){
        productRepository.deleteById(id);
    }

}
