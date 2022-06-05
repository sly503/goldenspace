package com.goldenspace.dto;

import java.math.BigDecimal;

public class BidDto {
    
    //bid dto
    private Long id;
    private Long auctionId;
    private BigDecimal price;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }




}