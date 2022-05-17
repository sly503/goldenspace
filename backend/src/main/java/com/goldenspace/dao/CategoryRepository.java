package com.goldenspace.dao;

import com.goldenspace.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "auctionCategory", path = "category")
public interface CategoryRepository extends JpaRepository<Category, Long> {
}