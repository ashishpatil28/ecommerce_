package com.ashish.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ashish.ecommerce.entity.CartItem;
import com.ashish.ecommerce.repository.CartRepository;
import com.ashish.ecommerce.repository.ProductRepository;

@Controller
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable Long id) {

        CartItem c = new CartItem();

        c.setProductId(id);
        c.setQuantity(1);

        cartRepository.save(c);

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String cart(Model model) {

        List<CartItem> items = cartRepository.findAll();

        model.addAttribute("items", items);

        return "cart";
    }
}