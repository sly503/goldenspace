import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Auction } from 'src/app/common/auction';
import { Bid } from 'src/app/common/bid';
import { AuctionService } from 'src/app/services/auction.service';
import { NgbModal,ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-auction-details',
  templateUrl: './auction-details.component.html',
  styleUrls: ['./auction-details.component.css'],
})
export class AuctionDetailsComponent implements OnInit {
  auction: Auction = new Auction;
  //list of bids
  bids: Bid[] = [];
  bid: Bid = new Bid();
  closeResult!: string;

  constructor(
    private auctionService: AuctionService,
    private route: ActivatedRoute,
    private modalService: NgbModal


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




  //add bid
  addBid(bid: Bid) {
    const theAuctionId: number = +this.route.snapshot.paramMap.get('id')!;

    this.auctionService.addBid(theAuctionId, bid).subscribe((data) => {
      this.bid = data;
      alert('Bid Placed Successfully');
    });
  }

  //open modal
  open(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }
  getDismissReason(reason: any) {
    throw new Error('Method not implemented.');
  }

}
