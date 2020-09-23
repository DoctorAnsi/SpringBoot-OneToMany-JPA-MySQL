package com.ashish.SpringBootJPA.controller;

import com.ashish.SpringBootJPA.entity.Product;
import com.ashish.SpringBootJPA.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts()
    {
        return productService.getProducts();
    }

    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable int id)
    {
        return productService.getProductById(id);
    }

    @GetMapping("/productByName/{name}")
    public List<Product> findProductByName(@PathVariable String name)
    {
        return productService.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct( @PathVariable int id){
        return productService.deleteProduct(id);
    }
}
