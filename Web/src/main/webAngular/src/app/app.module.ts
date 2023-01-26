import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuctionHouseComponent } from './auction-house/auction-house.component';
import { AuctionComponent } from './auction-house/auction/auction.component';
import { ItemComponent } from './auction-house/item/item.component';
import { ShoppingCartComponent } from './auction-house/shopping-cart/shopping-cart.component';
import { OrdersComponent } from './auction-house/orders/orders.component';
import { AuctionHouseService } from './auction-house/services/auction-house.service';
import { NavbarComponent } from './auction-house/navbar/navbar.component';
import { LoginComponent } from './auction-house/login/login.component';
import { SignUpComponent } from './auction-house/sign-up/sign-up.component';
import { PaginationComponent } from './auction-house/pagination/pagination.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { CreateAuctionComponent } from './auction-house/create-auction/create-auction.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AuthInterceptor } from './auction-house/interceptors/auth-interceptor';

@NgModule({
  declarations: [
    AppComponent,
    AuctionHouseComponent,
    AuctionComponent,
    ItemComponent,
    ShoppingCartComponent,
    OrdersComponent,
    NavbarComponent,
    LoginComponent,
    SignUpComponent,
    PaginationComponent,
    CreateAuctionComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    NgxPaginationModule,
    NgbModule,
  ],
  providers: [AuctionHouseService, AuthInterceptor],
  bootstrap: [AppComponent]
})
export class AppModule { }
