import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuctionListComponent } from './component/auction-list/auction-list.component';
import { AuctionCategoryMenuComponent } from './component/auction-category-menu/auction-category-menu.component';
import { AuctionDetailsComponent } from './component/auction-details/auction-details.component';
import { SearchComponent } from './component/search/search.component';
import { HttpClientModule } from '@angular/common/http';
import { AuctionService } from './services/auction.service';

@NgModule({
  declarations: [
    AppComponent,
    AuctionListComponent,
    AuctionCategoryMenuComponent,
    AuctionDetailsComponent,
    SearchComponent
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
