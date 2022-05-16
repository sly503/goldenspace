import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Auction } from '../common/auction';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuctionService {
  private baseUrl = 'http://localhost:8080/api/auctions';

  private categoryUrl = 'http://localhost:8080/api/auction-category';

  constructor(private httpClient: HttpClient) { }

  getAuctionList(): Observable<Auction[]> {
    return this.httpClient.get<getResponse>(this.baseUrl).pipe(
      map(response => response._embedded.auctions)
    );

  }

}

interface getResponse {
  _embedded: {
    auctions: Auction[];
  }
}

