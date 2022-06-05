package com.goldenspace.dao;

import com.goldenspace.entity.Category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findCategoryById(Long id);

    List<Category> deleteCategoryById(Long id);

}