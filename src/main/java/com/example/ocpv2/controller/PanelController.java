package com.example.ocpv2.controller;

import com.example.ocpv2.entity.Product;
import com.example.ocpv2.entity.Role;
import com.example.ocpv2.service.ProductService;
import com.example.ocpv2.service.RoleService;
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

    @Autowired
    private RoleService roleService;

    @GetMapping("/panel")
    public String showPanel(){
        return "panel";
    }

    @GetMapping("/panel/create-role")
    public String showCreateRoleForm(Model model) {
        model.addAttribute("role", new Role()); // Initialize an empty role object
        return "create-role";
    }

    @PostMapping("/panel/create-role")
    public String addRole(Role role) {
        roleService.saveRole(role);
        return "redirect:/panel";
    }

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