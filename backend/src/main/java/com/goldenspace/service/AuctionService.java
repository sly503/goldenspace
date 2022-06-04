package com.goldenspace.service;
import javax.transaction.Transactional;

import com.goldenspace.dao.AuctionRepository;
import com.goldenspace.dao.BidRepository;
import com.goldenspace.dto.BidDto;
import com.goldenspace.entity.Auction;
import com.goldenspace.entity.Bid;
import com.goldenspace.entity.Status;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuctionService {

    AuctionRepository auctionRepository;
    BidRepository bidRepository;

    //constructor
    public AuctionService(AuctionRepository auctionRepository,BidRepository bidRepository) {
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

    public Boolean setAuctionStatus(Long id) {
        Auction auction = auctionRepository.findById(id).get();
        //if auction is not null and auction is not sold and auction is not expired
        if(auction != null && auction.getStatus() != Status.SOLD && auction.getStatus() != Status.EXPIRED) {
            //if auction is active
            if(auction.getStatus() == Status.ACTIVE) {
                //if auction has no bids
                if(auction.getBids().size() == 0) {
                    //set auction status to expired
                    auction.setStatus(Status.UNSOLD);
                }
                //if auction has bids
                else {
                    
                    //set auction sold price to highest bid price
                    auction.setSoldPrice(auction.getBids().get(auction.getBids().size() - 1).getPrice());
                    //set auction status to sold
                    auction.setStatus(Status.SOLD);
                }
            }
            //if auction is sold
            else if(auction.getStatus() == Status.SOLD) {
                //set auction status to expired
                auction.setStatus(Status.EXPIRED);
            }
            return true;

        }
        return false;


 }


    


}