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
import { CrudformComponent } from './components/crudform/crudform.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { DialogComponent } from './components/crudform/dialog/dialog.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatRadioModule } from '@angular/material/radio';
import { FormsModule } from '@angular/forms';
import { BidstatusComponent } from './components/bidstatus/bidstatus.component';

@NgModule({
  declarations: [
    AppComponent,
    AuctionCategoryMenuComponent,
    AuctionDetailsComponent,
    AuctionListComponent,
    AuctionSearchComponent,
    CrudformComponent,
    DialogComponent,
    BidstatusComponent,
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NgbModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatRadioModule,
    NgbModule,
    FormsModule
  ],
  providers: [
    AuctionService,
    AuctionCategoryMenuComponent,
    AuctionDetailsComponent,
    AuctionListComponent,
    AuctionSearchComponent,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
