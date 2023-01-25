import {Component, OnInit} from '@angular/core';
import {Cart} from "../models/cart.model";
import {Subscription} from "rxjs/internal/Subscription";
import {AuctionHouseService} from "../services/auction-house.service";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

    cart: Cart;
    total: number;
    paid: boolean;
    sub: Subscription;

    constructor(private auctionHouseService: AuctionHouseService) {
        this.cart = this.auctionHouseService.Cart;
    }

    ngOnInit() {
        this.paid = false;
        this.sub = this.auctionHouseService.CartChanged.subscribe(() => {
            this.cart = this.auctionHouseService.Cart;
        });
        this.loadTotal();
    }

    pay() {
        this.paid = true;
        this.auctionHouseService.saveCart(this.cart).subscribe();
    }

    loadTotal() {
        this.sub = this.auctionHouseService.TotalChanged.subscribe(() => {
            this.total = this.auctionHouseService.Total;
        });
    }

}
