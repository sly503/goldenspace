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
  private categoryUrl = 'http://localhost:8080/api/categories';

  constructor(private httpClient: HttpClient) {}

  getAuctionList(categoryId: number): Observable<Auction[]> {
    const searchUrl = `${this.baseUrl}/search/findByCategoryId?id=${categoryId}`;
    return this.getAuctions(searchUrl);

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
}

interface GetResponseAuctions {
  _embedded: {
    auctions: Auction[];
  };
}

interface GetResponseCategory {
  _embedded: {
    categories: Category[];
  };
}
