package com.ashish.ecommerce.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ashish.ecommerce.entity.CartItem;
import com.ashish.ecommerce.entity.OrderItem;
import com.ashish.ecommerce.repository.CartRepository;
import com.ashish.ecommerce.repository.OrderRepository;

@Controller
public class OrderController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/checkout")
    public String checkout() {

        List<CartItem> cartItems = cartRepository.findAll();

        for (CartItem c : cartItems) {

            OrderItem o = new OrderItem();

            o.setProductName("Product " + c.getProductId());
            o.setPrice(0);
            o.setOrderDate(LocalDate.now().toString());

            orderRepository.save(o);
        }

        cartRepository.deleteAll(); // important fix

        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String orders(Model model) {

        model.addAttribute("orders", orderRepository.findAll());

        return "orders";
    }
}