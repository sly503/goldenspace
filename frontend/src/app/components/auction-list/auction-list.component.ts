import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Auction } from 'src/app/common/auction';
import { AuctionService } from 'src/app/services/auction.service';

@Component({
  selector: 'app-auction-list',
  templateUrl: './auction-list.component.html',
  styleUrls: ['./auction-list.component.css'],
})
export class AuctionListComponent implements OnInit {
  auctions: Auction[] = [];
  currentCategoryId!: number;
  currentCategoryName: any;
  searchMode!: boolean;

  constructor(
    private auctionService: AuctionService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.listAuctions();
    });
  }

  listAuctions() {
    this.searchMode = this.route.snapshot.paramMap.has('keyword');
    if (this.searchMode) {
      this.handleSearchAuctions();
    } else {
      this.handleListAuctions();
    }
  }


  handleListAuctions() {

    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');
    if (hasCategoryId) {
      this.currentCategoryId = +this.route.snapshot.paramMap.get('id')!;
      this.currentCategoryName = this.route.snapshot.paramMap.get('name');
    }else {
      this.currentCategoryId = 1;
      this.currentCategoryName = 'Default';
    }

    this.auctionService.getAuctionList(this.currentCategoryId).subscribe((data) => {
      this.auctions = data;
    });

  }

  handleSearchAuctions() {
    const theKeyword: string = this.route.snapshot.paramMap.get('keyword')!;
    this.auctionService
      .searchAuctions(theKeyword)
      .subscribe((data) => (this.auctions = data));
  }

}
