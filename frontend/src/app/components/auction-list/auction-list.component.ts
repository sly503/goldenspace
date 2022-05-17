import { Component, OnInit } from '@angular/core';
import { Auction } from 'src/app/common/auction';
import { AuctionService } from 'src/app/services/auction.service';

@Component({
  selector: 'app-auction-list',
  templateUrl: './auction-list.component.html',
  styleUrls: ['./auction-list.component.css']
})
export class AuctionListComponent implements OnInit {

  auctions: Auction[] = [];

  constructor(private auctionService: AuctionService) { }

  ngOnInit() {
    this.listAuctions();
  }

  listAuctions() {
    this.auctionService.getAuctionList().subscribe(
      data => {
        this.auctions = data;
      }
    )
  }

}
