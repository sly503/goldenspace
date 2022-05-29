import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Auction } from 'src/app/common/auction';
import { Bid } from 'src/app/common/bid';
import { AuctionService } from 'src/app/services/auction.service';

@Component({
  selector: 'app-auction-details',
  templateUrl: './auction-details.component.html',
  styleUrls: ['./auction-details.component.css'],
})
export class AuctionDetailsComponent implements OnInit {
  auction: Auction = new Auction;
  //list of bids
  bids: Bid[] = [];

  constructor(
    private auctionService: AuctionService,
    private route: ActivatedRoute

  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.handleAuctionDetails();
    });
    this.route.paramMap.subscribe(() => {
      this.handleBids();
    }
    );

  }

  handleAuctionDetails() {
    // get the "id" param string and convert string to a number using the "+" symbol (convert to number)
    const theAuctionId: number = +this.route.snapshot.paramMap.get('id')!;
    this.auctionService.getAuction(theAuctionId).subscribe((data) => {
      this.auction = data;
    }
    );

  }

  //list of bids for the auction
  handleBids() {
    const theAuctionId: number = +this.route.snapshot.paramMap.get('id')!;
    this.auctionService.getBidList(theAuctionId).subscribe((data) => {
      this.bids = data;
    }
    );
  }



}
