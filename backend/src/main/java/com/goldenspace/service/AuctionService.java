package com.goldenspace.service;

import javax.transaction.Transactional;

import com.goldenspace.dao.AuctionRepository;
import com.goldenspace.dao.BidRepository;
import com.goldenspace.dao.CategoryRepository;
import com.goldenspace.dto.AuctionCreate;
import com.goldenspace.dto.BidDto;
import com.goldenspace.dto.ServiceResponse;
import com.goldenspace.entity.Auction;
import com.goldenspace.entity.Bid;
import com.goldenspace.entity.Category;
import com.goldenspace.entity.Status;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuctionService {

    AuctionRepository auctionRepository;
    BidRepository bidRepository;
    CategoryRepository categoryRepository;

    // constructor
    public AuctionService(AuctionRepository auctionRepository, BidRepository bidRepository,
            CategoryRepository categoryRepository) {
        this.auctionRepository = auctionRepository;
        this.bidRepository = bidRepository;
        this.categoryRepository = categoryRepository;

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

    public ServiceResponse<String> closeAuction(Long id) {
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
                }
            }
        }
        // if auction is null
        else if (auction == null) {
            result = "Auction does not exist";
        }

        return result.equals("ok") ? ServiceResponse.success("Auction status changed") : ServiceResponse.error(result);

    }

    public ServiceResponse<String> addBid2(BidDto bid) {
        String result = "ok";
        Auction auction = auctionRepository.findById(bid.getAuctionId()).get();
        // if bid price is higher than auction current price and auction is active add
        // bid
        if (bid.getPrice().compareTo(auction.getCurrentPrice()) > 0 && auction.getStatus() == Status.ACTIVE) {
            Bid newBid = new Bid();
            newBid.setPrice(bid.getPrice());
            newBid.setAuction(auction);
            bidRepository.save(newBid);
            auction.addBid(newBid);
            auctionRepository.save(auction);
        } else {
            result = "Bid price is lower than current price or auction is not active";
        }
        return result.equals("ok") ? ServiceResponse.success("Bid added") : ServiceResponse.error(result);
    }

    // add auction
    public ServiceResponse<String> addAuction(AuctionCreate auctionCreate) {
        String result = "ok";
        Auction auction = new Auction();
        Category category = categoryRepository.findById(auctionCreate.getCategoryId()).get();

        // if category is not null
        if (category != null) {
            auction.setName(auctionCreate.getName());
            auction.setDescription(auctionCreate.getDescription());
            auction.setImageUrl(auctionCreate.getImageUrl());
            auction.setStartDate(auctionCreate.getStartDate());
            auction.setEndDate(auctionCreate.getEndDate());
            auction.setInitialPrice(auctionCreate.getInitialPrice());
            auction.setCurrentPrice(auctionCreate.getInitialPrice());
            auction.setCategory(category);
            auction.setStatus(Status.ACTIVE);
            auctionRepository.save(auction);
        } else {
            result = "Category does not exist";
        }
        return result.equals("ok") ? ServiceResponse.success("Auction added") : ServiceResponse.error(result);
    }
}