package com.goldenspace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goldenspace.dto.ServiceResponse;
import com.goldenspace.entity.Category;
import com.goldenspace.service.CategoryService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class CategoryController {
    protected CategoryService categoryService;

    @GetMapping("/categories/all")
    public ServiceResponse<List<Category>> all() {
        return categoryService.getAll();
    }
}
