import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuctionHouseComponent } from './auction-house/auction-house.component';
import { AuctionComponent } from './auction-house/auction/auction.component';
import { LoginComponent } from './auction-house/login/login.component';
import { SignUpComponent } from './auction-house/sign-up/sign-up.component';
import { CreateAuctionComponent } from './auction-house/create-auction/create-auction.component'

const routes: Routes = [
    {path: '', component: AuctionHouseComponent, pathMatch: 'full'},
    {path: 'auction/:id', component: AuctionComponent},
    {path: 'login', component: LoginComponent},
    {path: 'sign-up', component: SignUpComponent},
    {path: 'create', component: CreateAuctionComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
