package com.goldenspace.service;

import java.util.List;

import com.goldenspace.dao.BidRepository;
import com.goldenspace.entity.Bid;

public class BidService {
    public BidRepository bidRepository;

    public Bid addBid(Bid bid) {
        return bidRepository.save(bid);
    }

    public List<Bid> getBid() {
        return bidRepository.findAll();
    }

    public List<Bid> findBidById(Long id) {
        return bidRepository.findBidById(id);
    }

    public List<Bid> deleteBidById(Long id) {
        return bidRepository.deleteBidById(id);
    }

    public Bid updateBidById(Bid bid) {
        return bidRepository.save(bid);
    }

}
