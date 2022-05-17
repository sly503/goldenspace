import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-auction-search',
  templateUrl: './auction-search.component.html',
  styleUrls: ['./auction-search.component.css']
})
export class AuctionSearchComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  doSearch(value:String){
    console.log(value)
    this.router.navigateByUrl(`/search/${value}`)
  }

}