import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Auction } from '../common/auction';
import { HttpClient } from '@angular/common/http';
import { Category } from '../common/category';

@Injectable({
  providedIn: 'root',
})

export class AuctionService {
  private baseUrl = 'http://localhost:8080/api/auctions';
  private categoryUrl = 'http://localhost:8080/api/category';

  constructor(private httpClient: HttpClient) {}

  getAuctionListPaginate(
    thePage: number,
    theSize: number,
    theCategoryId: number
  ): Observable<GetResponseAuctions> {
    const searchUrl =
      `${this.baseUrl}/search/findByCategoryId?id=${theCategoryId}` +
      `&page=${thePage}&size=${theSize}`;
    return this.httpClient.get<GetResponseAuctions>(searchUrl);
  }

  getAuction(theAuctionId: number): Observable<Auction> {
    const auctionUrl = `${this.baseUrl}/${theAuctionId}`;
    return this.httpClient.get<Auction>(auctionUrl);
  }

  getAuctionList(): Observable<Auction[]> {
    return this.httpClient.get<GetResponseAuctions>(this.baseUrl).pipe(
      map(response => response._embedded.auctions)
    );
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

  getAuctionCategories(): Observable<Category[]> {
    return this.httpClient
      .get<GetResponseAuctionCategory>(this.categoryUrl)
      .pipe(map((response) => response._embedded.category));
  }
}

interface GetResponseAuctions {
  _embedded: {
    auctions: Auction[];
  };
}

interface GetResponseAuctionCategory {
  _embedded: {
    category: Category[];
  }
}
