package com.ashish.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashish.ecommerce.entity.Product;
import com.ashish.ecommerce.repository.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/home")
    public String home(Model model) {

        List<Product> products = productRepository.findAll();

        model.addAttribute("products", products);

        return "home";
    }

    @GetMapping("/product")
    public String product(@RequestParam Long id, Model model) {

        Product p = productRepository.findById(id).orElse(null);

        model.addAttribute("product", p);

        return "product";
    }
}