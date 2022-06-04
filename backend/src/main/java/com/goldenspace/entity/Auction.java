package com.goldenspace.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Data;

@Entity
@Table(name = "auction")
@Data
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    @CreationTimestamp
    private Date startDate;

    @Column(name = "end_date")
    @UpdateTimestamp
    private Date endDate;

    @Column(name = "initial_price")
    private BigDecimal initialPrice;

    @Column(name = "current_price")
    private BigDecimal currentPrice;

    @Column(name = "sold_price")
    private BigDecimal soldPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    //default value is active
    private Status status = Status.ACTIVE;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auction")
    @JsonIgnore
    private List<Bid> bids;


    public BigDecimal getSoldPrice() {
        return soldPrice;
    }


    public void setSoldPrice(BigDecimal soldPrice) {
        this.soldPrice = soldPrice;
    }


    public Status getStatus() {
        return status;
    }


    public void setStatus(Status status) {
        this.status = status;
    }


    public List<Bid> getBids() {
        return bids;
    }


    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }


    public void addBid(Bid bid) {
        //if bid is not null and bid is not equal or lower than current price
        if (bid != null && bid.getPrice().compareTo(currentPrice) > 0) {
            currentPrice = bid.getPrice();
            bid.setAuction(this);
            bids.add(bid);
        }
    }

    




    

    //@Column(name = "city")
    //private City city;
    /*

     * 
     * @ManyToOne
     * 
     * @JoinColumn(ame = "user_id", nullable = false)
     * private User user;
     */

}
