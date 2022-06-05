package com.goldenspace.controller;

import com.goldenspace.dto.AuctionRead;
import com.goldenspace.dto.BidDto;
import com.goldenspace.dto.ServiceResponse;
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

    @PostMapping("/auction/addBid")
    public ServiceResponse<String> addBid(@RequestBody BidDto bid) {
        return auctionService.addBid2(bid);
    }

    // put mapping to close auction
    @PostMapping("/auction/close")
    public ServiceResponse<String> closeAuction(@RequestBody AuctionRead dto) {
        return auctionService.closeAuction(dto.getId()) ;
    }

}