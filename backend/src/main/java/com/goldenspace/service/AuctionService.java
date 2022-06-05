package com.goldenspace.service;

import java.util.List;

import javax.transaction.Transactional;

import com.goldenspace.dao.AuctionRepository;
import com.goldenspace.dao.BidRepository;
import com.goldenspace.dto.BidDto;
import com.goldenspace.entity.Auction;
import com.goldenspace.entity.Bid;
import com.goldenspace.enums.Status;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Transactional
public class AuctionService {

    AuctionRepository auctionRepository;
    BidRepository bidRepository;

    // constructor
    public AuctionService(AuctionRepository auctionRepository, BidRepository bidRepository) {
        this.auctionRepository = auctionRepository;
        this.bidRepository = bidRepository;
    }

    public Auction addBid(Long id, BidDto bid) {
        Auction auction = auctionRepository.findById(id).get();
        Bid newBid = new Bid();
        newBid.setPrice(bid.getPrice());
        newBid.setAuction(auction);
        bidRepository.save(newBid);
        auction.addBid(newBid);
        return auctionRepository.save(auction);
    }

    public String closeAuction(Long id) {
        String result = "ok";
        Auction auction = auctionRepository.findById(id).get();
        // if auction is not null and auction is not sold and auction is not expired
        if (auction != null && auction.getStatus() != Status.SOLD && auction.getStatus() != Status.EXPIRED) {
            // if auction is active
            if (auction.getStatus() == Status.ACTIVE) {
                // if auction has no bids
                if (auction.getBids().size() == 0) {
                    // set auction status to expired
                    auction.setStatus(Status.UNSOLD);
                    result = "Auction has no bids and is expired";
                }
                // if auction has bids
                else {

                    // set auction sold price to highest bid price
                    auction.setSoldPrice(auction.getBids().get(auction.getBids().size() - 1).getPrice());
                    // set auction status to sold
                    auction.setStatus(Status.SOLD);
                    result = "Auction has been sold with price: " + auction.getSoldPrice();
                }
            }
        }
        // if auction is null
        else if (auction == null) {
            result = "Auction does not exist";
        }

        return result;

    }

    public Auction addAuction(Auction auction) {
        return auctionRepository.save(auction);
    }

    public List<Auction> getAuction() {
        return auctionRepository.findAll();
    }

    public List<Auction> findAuctionById(Long id) {
        return auctionRepository.findAuctionById(id);
    }

    public List<Auction> deleteAuctionById(Long id) {
        return auctionRepository.deleteAuctionById(id);
    }

    public Auction updateAuctionById(@RequestBody Auction auction) {
        return auctionRepository.save(auction);
    }
}
