package com.goldenspace.service;

import javax.transaction.Transactional;

import com.goldenspace.dao.AuctionRepository;
import com.goldenspace.dao.BidRepository;
import com.goldenspace.dto.BidDto;
import com.goldenspace.entity.Auction;
import com.goldenspace.entity.Bid;

import org.springframework.stereotype.Service;

@Service
public class AuctionService {

    AuctionRepository auctionRepository;
    BidRepository bidRepository;

    //constructor
    public AuctionService(AuctionRepository auctionRepository,BidRepository bidRepository) {
        this.auctionRepository = auctionRepository;
        this.bidRepository = bidRepository;
    }

    @Transactional
    public Auction addBid(Long id, BidDto bid) {
        Auction auction = auctionRepository.findById(id).get();
        Bid newBid = new Bid();
        newBid.setPrice(bid.getPrice());
        newBid.setAuction(auction);
        bidRepository.save(newBid);
        auction.addBid(newBid);
        return auctionRepository.save(auction);
    }
    
}