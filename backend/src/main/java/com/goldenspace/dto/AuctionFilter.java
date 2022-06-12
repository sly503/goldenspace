package com.goldenspace.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuctionFilter {
    protected String query;
    protected Long categoryId;
}
