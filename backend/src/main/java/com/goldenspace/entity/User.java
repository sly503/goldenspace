package com.goldenspace.entity;

import java.util.Date;
import javax.persistence.*;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "status")
    private boolean status;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "city")
    private String city;

    /*
     * @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
     * private Set<Bid> bids;
     * 
     * @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
     * private Set<Auction> auctions;
     */

}
