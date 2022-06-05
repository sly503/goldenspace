package com.goldenspace.controller;

import com.goldenspace.dto.BidDto;
import com.goldenspace.entity.Auction;
import com.goldenspace.service.AuctionService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuctionController {

    AuctionService auctionService;

    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @PostMapping("/auction/addBid/{id}")
    public boolean addBid(@PathVariable Long id, @RequestBody BidDto bid) {
        if (auctionService.addBid(id, bid) != null) {
            return true;
        } else
            return false;
    }

    // put mapping to close auction
    @PostMapping("/auctions/close/{id}")
    public String closeAuction(@PathVariable Long id) {

        return auctionService.closeAuction(id);

    }

    @PostMapping("/addAuction")
    public Auction addAuction(@RequestBody Auction auction) {
        return auctionService.addAuction(auction);
    }

    @GetMapping("/getAuction")
    public List<Auction> getAuction() {
        return auctionService.getAuction();
    }

    @GetMapping("/find/{id}")
    public List<Auction> findAuctionById(@PathVariable("id") Long id) {
        return auctionService.findAuctionById(id);
    }

    @DeleteMapping("/delete/{id}")
    public List<Auction> deleteAuctionById(@PathVariable("id") Long id) {
        return auctionService.deleteAuctionById(id);
    }

    @PostMapping("/update/{id}")
    public Auction updateAuctionById(@PathVariable("id") Long id, @RequestBody Auction auction) {
        return auctionService.updateAuctionById(auction);
    }
}
