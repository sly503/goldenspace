import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuctionCategoryMenuComponent } from './components/auction-category-menu/auction-category-menu.component';
import { AuctionDetailsComponent } from './components/auction-details/auction-details.component';
import { AuctionListComponent } from './components/auction-list/auction-list.component';
import { AuctionSearchComponent } from './components/auction-search/auction-search.component';
import { AuctionService } from './services/auction.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    AuctionCategoryMenuComponent,
    AuctionDetailsComponent,
    AuctionListComponent,
    AuctionSearchComponent
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NgbModule
  ],
  providers: [AuctionService, AuctionCategoryMenuComponent, AuctionDetailsComponent, AuctionListComponent, AuctionSearchComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }

