package com.goldenspace.dao;

import com.goldenspace.entity.Auction;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource
public interface AuctionRepository extends JpaRepository<Auction, Long> {

    Page<Auction> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    Page<Auction> findByNameContaining(@RequestParam("name") String name, Pageable pageable);

    // Page<Auction> findByDescriptionContaining(@RequestParam("description") String
    // description, Pageable pageable);
    // Page<Auction> findByCityContaining(@RequestParam("city") String city,
    // Pageable pageable);
    List<Auction> findAuctionById(Long id);

    List<Auction> deleteAuctionById(Long id);

}