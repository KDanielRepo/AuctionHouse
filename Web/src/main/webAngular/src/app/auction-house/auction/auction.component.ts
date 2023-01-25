import { Component, OnInit } from '@angular/core';
import {Auction} from "../models/auction.model";
import {AuctionHouseService} from "../services/auction-house.service";
import {Subscription} from "rxjs/internal/Subscription";
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-auction',
  templateUrl: './auction.component.html',
  styleUrls: ['./auction.component.css']
})
export class AuctionComponent implements OnInit {

    orderFinished = false;
    auction: Auction;
    sub: Subscription;
    id: number;

  constructor(private auctionHouseService: AuctionHouseService, private route: ActivatedRoute) {
   }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
            this.id = params['id'];
            });
            console.log(this.id);
    this.loadAuction();
  }

  ngOnDestroy() {
      this.sub.unsubscribe();
    }

  loadAuction(){
    this.auctionHouseService.getAuction(this.id)
      .subscribe(auction => {
        this.auction = auction;
        console.log(this.auction);
      },
      (error) => console.log(error)
      );
  }

  get auctionTitle(){
    return (this.auction && this.auction.title) ? this.auction.title : ""
  }

  get auctionPrice(){
    return (this.auction && this.auction.price) ? this.auction.price : 0
  }
  get auctionQuantity(){
    return (this.auction && this.auction.quantity) ? this.auction.quantity : 0
  }
  get auctionAuctionEnd(){
    return (this.auction && this.auction.auctionEnd) ? this.auction.auctionEnd : 0
  }

}
