package com.goldenspace.dao;

import com.goldenspace.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Long> {

}
