package com.goldenspace.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "auction")
@Data
public class Auction {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name = "name")
private String name;
@Column(name = "description")
private String description;
@Column(name = "start_date")
private Date startDate;
@Column(name = "end_date")
private Date endDate;
@Column(name = "start_price")
private BigDecimal startPrice;
@Column(name = "current_price")
private BigDecimal currentPrice;
@Column(name = "status")
private Status status;
@Column(name = "image_url")
private String imageUrl;

@OneToMany(cascade = CascadeType.ALL, mappedBy = "auction")
private Set<Bid> bids;

@ManyToOne
@JoinColumn(name = "user_id", nullable = false)
private User user;


@ManyToOne
@JoinColumn(name = "category_id", nullable = false)
private Category category;

}
