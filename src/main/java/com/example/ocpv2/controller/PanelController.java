package com.example.ocpv2.controller;

import com.example.ocpv2.entity.Product;
import com.example.ocpv2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PanelController {
    // Existing mappings...
    @Autowired
    private ProductService productService;

    // Handle product addition form
    @GetMapping("/panel/add-product")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        // Return a view for adding a product (e.g., add-product.html)
        return "add-product";
    }

    @PostMapping("/panel/add-product")
    public String addProducts(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/panel";
    }
}