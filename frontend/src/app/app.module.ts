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
    HttpClientModule
  ],
  providers: [AuctionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
