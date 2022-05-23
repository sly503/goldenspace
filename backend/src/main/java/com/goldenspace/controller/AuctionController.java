package com.goldenspace.controller;

import com.goldenspace.dto.BidDto;
import com.goldenspace.entity.Auction;
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
    public Auction addBid(@PathVariable Long id, @RequestBody BidDto bid) {
        return auctionService.addBid(id, bid);
    }
}