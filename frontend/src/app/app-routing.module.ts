import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddAuctionComponent } from './components/add-auction/add-auction.component';
import { AuctionDetailsComponent } from './components/auction-details/auction-details.component';
import { AuctionListComponent } from './components/auction-list/auction-list.component';
import { AuctionSearchComponent } from './components/auction-search/auction-search.component';

const routes: Routes = [
  {path: 'auctions/:id', component: AuctionDetailsComponent},
  {path: 'search/:keyword', component: AuctionListComponent},
  {path: 'category/:id', component: AuctionListComponent},
  {path: 'category', component: AuctionListComponent},
  {path: 'auctions', component: AuctionListComponent},
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
