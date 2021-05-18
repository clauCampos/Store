package org.factoriaf5.store.controllers;

import org.factoriaf5.store.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private List<Product> products = new ArrayList<>();


    @GetMapping("/health")
    public String check() {
        return "Hello I'm a server";
    }

    @GetMapping("/products")
    public List<Product> allProducts() {
        return products;
    }

    @PostMapping("/products")
    public void addProduct(Product product) {
        products.add(product);
    }

    public Product findProduct(String name, List<Product> products) {

        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    @DeleteMapping("products/{name}")
    public void deleteProduct(@PathVariable String name) {
        Product product = findProduct(name,products);
        products.remove(product);
    }

}

