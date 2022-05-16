package com.goldenspace.dao;

import com.goldenspace.entity.Auction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(collectionResourceRel = "auction", path = "auction")
public interface AuctionRepository extends JpaRepository<Auction, Long> {


    Page<Auction> findByCategory(@RequestParam("category") String category, Pageable pageable);

}