package com.goldenspace.service;

import java.util.List;

import com.goldenspace.dao.CategoryRepository;
import com.goldenspace.entity.Category;

public class CategoryService {
    public CategoryRepository categoryRepository;

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    public List<Category> findCategoryById(Long id) {
        return categoryRepository.findCategoryById(id);
    }

    public List<Category> deleteCategoryById(Long id) {
        return categoryRepository.deleteCategoryById(id);
    }

    public Category updateCategoryById(Category category) {
        return categoryRepository.save(category);
    }
}
