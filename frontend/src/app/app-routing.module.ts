import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuctionDetailsComponent } from './components/auction-details/auction-details.component';
import { AuctionListComponent } from './components/auction-list/auction-list.component';
import { AuctionSearchComponent } from './components/auction-search/auction-search.component';

const routes: Routes = [
  {path: 'category/:id', component: AuctionListComponent},
  {path: 'category', component: AuctionListComponent},
  {path: 'auctions', component: AuctionListComponent},
  {path: '', redirectTo: '/auctions', pathMatch: 'full'},
  {path: '**', redirectTo: '/auctions', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
