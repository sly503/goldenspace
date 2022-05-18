import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Auction } from 'src/app/common/auction';
import { AuctionService } from 'src/app/services/auction.service';

@Component({
  selector: 'app-auction-details',
  templateUrl: './auction-details.component.html',
  styleUrls: ['./auction-details.component.css'],
})
export class AuctionDetailsComponent implements OnInit {
  auction: Auction = new Auction;
  constructor(
    private auctionService: AuctionService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.handleAuctionDetails();
    });
  }
  handleAuctionDetails() {
    // get the "id" param string and convert string to a number using the "+" symbol (convert to number)
    const theAuctionId: number = +this.route.snapshot.paramMap.get('id')!;
    this.auctionService.getAuction(theAuctionId).subscribe((data) => {
      this.auction = data;
    }
    );

  }


}
