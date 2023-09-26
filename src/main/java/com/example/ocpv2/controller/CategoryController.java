package com.example.ocpv2.controller;

import com.example.ocpv2.entity.Category;
import com.example.ocpv2.entity.exceptions.ProductNotFoundException;
import com.example.ocpv2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public String addCategory(@ModelAttribute Category category) {
        Category saveCategory = categoryService.saveCategory(category);
        return "homePage";
    }

    @GetMapping("/{name}")
    public ResponseEntity<Category> getCategoryByName(@PathVariable String name) {
        Category category = categoryService.searchCategoryByName(name);
        if (name == null) {
            throw new ProductNotFoundException("Nu se gaseste categorie cu acest nume!");
        }
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{name}")
    public String deleteCategoryByName(@PathVariable String name) {
        categoryService.deleteCategoryByName(name);
        return "Categoria a fost stearsa cu succes!";
    }

}
