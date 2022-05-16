package com.goldenspace.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
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

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "status")
    private boolean status;

    //@Column(name = "city")
    //private City city;

    /*
     * @OneToMany(cascade = CascadeType.ALL, mappedBy = "auction")
     * private Set<Bid> bids;
     * 
     * @ManyToOne
     * 
     * @JoinColumn(name = "user_id", nullable = false)
     * private User user;
     */

}
