package com.goldenspace.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.goldenspace.entity.Bid;
import com.goldenspace.service.BidService;

public class BidController {
    public BidService bidService;

    @PostMapping("/addBid")
    public Bid addBid(@RequestBody Bid bid) {
        return bidService.addBid(bid);
    }

    @GetMapping("/getBid")
    public List<Bid> getBid() {
        return bidService.getBid();
    }

    @GetMapping("/find/{id}")
    public List<Bid> findBidById(@PathVariable("id") Long id) {
        return bidService.findBidById(id);
    }

    @DeleteMapping("/delete/{id}")
    public List<Bid> deleteBidById(@PathVariable("id") Long id) {
        return bidService.deleteBidById(id);
    }

    @PostMapping("/update/{id}")
    public Bid updateBidById(@PathVariable("id") Long id, @RequestBody Bid bid) {
        return bidService.updateBidById(bid);
    }
}
