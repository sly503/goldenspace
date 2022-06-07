import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddAuctionComponent } from './components/add-auction/add-auction.component';
import { AuctionDetailsComponent } from './components/auction-details/auction-details.component';
import { AuctionListComponent } from './components/auction-list/auction-list.component';
import { AddNewsComponent } from './components/news/add-news/add-news.component';
import { NewsDetailsComponent } from './components/news/news-details/news-details.component';
import { NewsComponent } from './components/news/news.component';

const routes: Routes = [
  {path: 'auctions/:id', component: AuctionDetailsComponent},
  {path: 'search/:keyword', component: AuctionListComponent},
  {path: 'category/:id', component: AuctionListComponent},
  {path: 'category', component: AuctionListComponent},
  {path: 'auctions', component: AuctionListComponent},
  {path: "news", component: NewsComponent},
  {path: "news/:id", component: NewsDetailsComponent},
  {path: "addNews", component: AddNewsComponent},
  //add a route for add auction form
  {path: 'addAuction', component: AddAuctionComponent},
  {path: '', redirectTo: '/auctions', pathMatch: 'full'},
  {path: '**', redirectTo: '/auctions', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
