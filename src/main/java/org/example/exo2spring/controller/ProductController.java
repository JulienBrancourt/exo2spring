package org.example.exo2spring.controller;

import org.example.exo2spring.model.Product;
import org.example.exo2spring.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String all(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        System.out.println("on passe bien par là !");
        System.out.println(products);
        return "pageall";
    }

    @GetMapping("detail/{productId}")
    public String detailPage(@PathVariable("productId") UUID productId, Model model) {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "detail";
    }

    @GetMapping("/filter")
    public String filterProduct(@RequestParam("category") String category,@RequestParam ("pricemax") double price,
                                Model model) {
        List<Product> products = productService.getProductByCategoryAndPriceMax(category, price);
        model.addAttribute("products", products);
        return "filter";
    }
}
