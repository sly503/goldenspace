package com.goldenspace.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;
import lombok.Data;

@Entity
@Table(name = "bid")
@Data
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // @ManyToOne
    // @JoinColumn(name = "user_id", nullable = false)
    // private User user;
    @ManyToOne
    @JoinColumn(name = "auction_id", nullable = false)
    @JsonIgnore
    private Auction auction;

    @Column(name = "price")
    private BigDecimal price;

    // (DateTime or date )
    @Column(name = "bid_time")
    @CreationTimestamp
    private Date bidTime;


    public Bid() {
        this.bidTime = new Date();
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // get price
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setAuction(Auction auction2) {
        this.auction = auction2;
    }

}
