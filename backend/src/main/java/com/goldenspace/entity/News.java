package com.goldenspace.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "news")
@Data
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "create_time")
    @CreationTimestamp
    private Date createTime;

    @Column(name = "update_time")
    @UpdateTimestamp
    private Date updateTime;

    @Column(name = "status")
    private boolean status;

}
