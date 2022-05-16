package com.goldenspace.dao;

import com.goldenspace.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(collectionResourceRel = "auctionCategory", path = "auction-category")
public interface CategoryRepository extends JpaRepository<Category, Long> {

    //search by name
    Page<Category> findBycategoryNameContaining(@RequestParam("name") String name, Pageable pageable);


    //find by id pageable
    Page<Category> findById(@RequestParam("id") Long id, Pageable pageable);
    
    //find main categories
    Page<Category> findByParentIdIsNull(Pageable pageable);

    

}