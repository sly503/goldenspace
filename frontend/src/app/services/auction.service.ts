import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Auction } from '../common/auction';
import { HttpClient } from '@angular/common/http';
import { Category } from '../common/category';
import { Bid } from '../common/bid';

@Injectable({
  providedIn: 'root',
})
export class AuctionService {

  private baseUrl = 'http://localhost:8080/api/auctions';
  private categoryUrl = 'http://localhost:8080/api/categories';
  private PostUrl = 'http://localhost:8080/auction/addBid';

  constructor(private httpClient: HttpClient) {}



  getAuctionListPaginate(thePage: number,
    thePageSize: number,
    theCategoryId: number): Observable<GetResponseAuctions> {

    const searchUrl = `${this.baseUrl}/search/findByCategoryId?id=${theCategoryId}`
      + `&page=${thePage}&size=${thePageSize}`;

    return this.httpClient.get<GetResponseAuctions>(searchUrl);
  }


  getAuctionList(categoryId: number): Observable<Auction[]> {
    const searchUrl = `${this.baseUrl}/search/findByCategoryId?id=${categoryId}`;
    return this.getAuctions(searchUrl);

  }

  getBidList(auctionId: number): Observable<Bid[]> {
    const searchUrl = `${this.baseUrl}/${auctionId}/bids`;
    return this.getBids(searchUrl);
  }

  getBids(searchUrl: string): Observable<Bid[]> {
    return this.httpClient
      .get<GetResponseBids>(searchUrl)
      .pipe(map((response) => response._embedded.bids));
  }


  getAuctionCategories(): Observable<Category[]> {
    return this.httpClient
      .get<GetResponseCategory>(this.categoryUrl)
      .pipe(map((response) => response._embedded.categories));
  }

  searchAuctions(theKeyword: string): Observable<Auction[]> {
    const searchUrl = `${this.baseUrl}/search/findByNameContaining?name=${theKeyword}`;
    return this.getAuctions(searchUrl);
  }

  private getAuctions(searchUrl: string): Observable<Auction[]> {
    return this.httpClient
      .get<GetResponseAuctions>(searchUrl)
      .pipe(map((response) => response._embedded.auctions));
  }

  getAuction(theAuctionId: number): Observable<Auction> {
    const url = `${this.baseUrl}/${theAuctionId}`;
    return this.httpClient.get<Auction>(url);
  }

  addBid(auctionId: number, bid: Bid): Observable<Bid> {
    const url = `${this.PostUrl}/${auctionId}`
    return this.httpClient.post<Bid>(url, bid);
  }

  //close auction
  closeAuction(theAuctionId: number): Observable<Auction> {
    const url = `${this.baseUrl}/close/${theAuctionId}`;
    return this.httpClient.put<Auction>(url, theAuctionId);
  }

}

interface GetResponseAuctions {
  _embedded: {
    auctions: Auction[];
  };
  page: {
    size: number,
    totalElements: number,
    totalPages: number,
    number: number
  }
}

interface GetResponseCategory {
  _embedded: {
    categories: Category[];
  };
}
// get a response of bids
interface GetResponseBids {
  _embedded: {
    bids: Bid[];
  };
}





