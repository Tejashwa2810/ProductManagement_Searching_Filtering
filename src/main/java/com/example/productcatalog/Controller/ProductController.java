package com.example.productcatalog.Controller;

import com.example.productcatalog.Service.ProductService;
import com.example.productcatalog.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        Product product = productService.getSingleProduct(id);
        return product;
    }

    @GetMapping("/product")
    public List<Product> getSearchedProducts(
            @RequestParam(value = "search", required = false, defaultValue = "") String search,
            @RequestParam(value = "minpricefilter", required = false, defaultValue = "0") Integer minpricefilter,
            @RequestParam(value = "maxpricefilter", required = false, defaultValue = "0") Integer maxpricefilter) {

        List<Product> products = productService.getSearchedProducts(search, minpricefilter, maxpricefilter);
        return products;
    }

    @GetMapping("/product/getall")
    public List<Product> getAllProduct(){
        List<Product> products = productService.getAllProducts();
        return products;
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    @PostMapping("/product/createall")
    public List<Product> createAllProducts(@RequestBody List<Product> products) {
        return productService.createAllProducts(products);
    }

    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        productService.deleteId(id);
        String str = "The item has been deleted";
        return str;
    }

}
