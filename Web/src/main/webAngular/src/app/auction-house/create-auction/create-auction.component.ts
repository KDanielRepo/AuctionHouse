import { Component, OnInit } from '@angular/core';
import {AuctionHouseService} from "../services/auction-house.service";
import {Auction} from "../models/auction.model";

@Component({
  selector: 'app-create-auction',
  templateUrl: './create-auction.component.html',
  styleUrls: ['./create-auction.component.css']
})
export class CreateAuctionComponent implements OnInit {

  form: any = {
    title: null,
    description: null,
    price: null,
    //auctionEnd: null,
    quantity: null,
    //itemImages: null
  };
  isCreationSuccessful = false;
  errorMessage = '';
  auction: Auction = new Auction();

  onSubmit(): void {
      //const { title, description, price, auctionEnd, quantity, itemImages} = this.form;

      this.auction.title = this.form.title;
      this.auction.price = this.form.price;
      this.auction.quantity = this.form.quantity;
      //this.auction.auctionEnd = this.form.auctionEnd;
      //this.auction.pictureUrl = this.form.pictureUrl;

      this.auctionHouseService.createAuction(this.auction).subscribe(
        data => {
          this.isCreationSuccessful = true;
          //this.reloadPage();
        },
        err => {
          this.errorMessage = err.error.message;
          this.isCreationSuccessful = false;
        }
      );
  }

  constructor(private auctionHouseService: AuctionHouseService) { }

  ngOnInit(): void {

  }

}
