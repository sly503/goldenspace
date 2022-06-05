package com.goldenspace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.goldenspace.entity.Category;
import com.goldenspace.service.CategoryService;

public class CategoryController {
    public CategoryService categoryService;

    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @GetMapping("/getCategory")
    public List<Category> getCategory() {
        return categoryService.getCategory();
    }

    @GetMapping("/find/{id}")
    public List<Category> findCategoryById(@PathVariable("id") Long id) {
        return categoryService.findCategoryById(id);
    }

    @DeleteMapping("/delete/{id}")
    public List<Category> deleteCategoryById(@PathVariable("id") Long id) {
        return categoryService.deleteCategoryById(id);
    }

    @PostMapping("/update/{id}")
    public Category updateCategoryById(@PathVariable("id") Long id, @RequestBody Category category) {
        return categoryService.updateCategoryById(category);
    }
}
