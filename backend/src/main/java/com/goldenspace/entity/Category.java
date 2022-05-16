package com.goldenspace.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Auction> auctions;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_image_url")
    private String categoryImageUrl;

}
