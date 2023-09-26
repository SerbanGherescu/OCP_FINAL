package com.example.ocpv2.service;

import com.example.ocpv2.entity.Category;
import com.example.ocpv2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category searchCategoryByName(String name) {
        Category category = categoryRepository.findByName(name).get();
        return category;
    }

    public void deleteCategoryByName(String name) {
        categoryRepository.deleteByName(name);
    }

}
