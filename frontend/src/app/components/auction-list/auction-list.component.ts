import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Auction } from 'src/app/common/auction';
import { AuctionService } from 'src/app/services/auction.service';

@Component({
  selector: 'app-auction-list',
  templateUrl: './auction-list.component.html',
  styleUrls: ['./auction-list.component.css']
})
export class AuctionListComponent implements OnInit {
  auctions: Auction[] = [];
  currentCategoryId: number = 1;
  previousCategoryId: number = 1;
  currentCategoryName: string | undefined;
  searchMode: boolean = false;

  thePageNumber: number = 1;
  thePageSize: number = 10;
  theTotalElements: number =0;


  constructor(private auctionService: AuctionService,
    private route: ActivatedRoute) { }


  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.listAuctions();
    })



  }

  listAuctions() {
    this.auctionService.getAuctionList().subscribe(
      data => {
        this.auctions = data;
      }
    )
  }


}
