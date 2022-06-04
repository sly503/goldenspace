package com.goldenspace.controller;

import com.goldenspace.dto.BidDto;
import com.goldenspace.service.AuctionService;

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

}