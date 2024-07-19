package org.example.exo2spring.service;

import org.example.exo2spring.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    private final List<Product> products;

    public ProductService() {
        products = new ArrayList<>();

        Product product1 = Product
                .builder()
                .id(UUID.randomUUID())
                .name("Product 1")
                .category("jouet")
                .price(15.5)
                .build();

        Product product2 = Product
                .builder()
                .id(UUID.randomUUID())
                .name("Product 2")
                .category("bricolage")
                .price(100.15)
                .build();

        Product product3 = Product
                .builder()
                .id(UUID.randomUUID())
                .name("Product 3")
                .category("jardinage")
                .price(2.99)
                .build();

        Product product4 = Product
                .builder()
                .id(UUID.randomUUID())
                .name("Product 4")
                .category("bricolage")
                .price(25.00)
                .build();

        Product product5 = Product
                .builder()
                .id(UUID.randomUUID())
                .name("Product 5")
                .category("jouet")
                .price(51.25)
                .build();

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(UUID id) {
        return products
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public List<Product> getProductByCategoryAndPriceMax(String category, Double price) {
        return products
                .stream()
                .filter(p -> p.getCategory().equals(category) && p.getPrice() <= price)
                .toList();



    }
}
