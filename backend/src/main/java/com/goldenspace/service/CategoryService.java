package com.goldenspace.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.goldenspace.dao.CategoryRepository;
import com.goldenspace.dto.ServiceResponse;
import com.goldenspace.entity.Category;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CategoryService {
    protected CategoryRepository categoryRepository;

    public ServiceResponse<List<Category>> getAll() {
        return ServiceResponse.success(categoryRepository.findAll());
    }
}
