import { Component, OnInit } from '@angular/core';
import { AuctionService } from 'src/app/services/auction.service';
import { NgbModal,ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { AuctionDto } from 'src/app/common/auction-dto';

@Component({
  selector: 'app-add-auction',
  templateUrl: './add-auction.component.html',
  styleUrls: ['./add-auction.component.css'],
})


export class AddAuctionComponent implements OnInit {
  auctionDto: AuctionDto = new AuctionDto();
  closeResult!: string;

  constructor(
    private auctionService: AuctionService,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {}

  addAuction(auction: AuctionDto) {
    // Save to database
    this.auctionService.addAuction(auction).subscribe({
      next: (data) => {
          if (data.success) {
            alert('Auction added successfully.');

          }
          else {
            alert(data.messages.join('\n'));
          }
      },
      error: (err) => {
        console.log(err);
      }
    })
  }

  open(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }
  getDismissReason(reason: any) {
    throw new Error('Category is required.');
  }


}
